package btctrader;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import btctrader.data.Candle;
import btctrader.data.History;
import btctrader.data.Product;
import btctrader.data.handler.DataHandler;
import btctrader.observer.BalanceObserver;
import btctrader.order.Order;
import btctrader.order.OrderFactory;
import btctrader.order.OrderSide;
import btctrader.strategy.close.ClosingDecision;
import btctrader.strategy.close.ClosingStrategy;
import btctrader.strategy.open.OpeningDecision;
import btctrader.strategy.open.OpeningStrategy;

public class BtcTrader {

	private static Logger LOGGER = LoggerFactory.getLogger(BtcTrader.class);

	private DataHandler dataHandler;
	private OpeningStrategy openingStrategy;
	private ClosingStrategy closingStrategy;
	private OrderFactory orderFactory;
	private Order order;
	private List<Order> orderHistory = new ArrayList<Order>();
	private double balance = 100000;
	private List<BalanceObserver> balanceObservers = new ArrayList<BalanceObserver>();

	public void trade(LocalDateTime start, Period delta, ChronoUnit aggregation, Product product) {
		History history = dataHandler.load(start, delta, aggregation, product);
		history.getCandles().stream().forEach(c -> replay(c));
	}

	private void replay(Candle candle) {
		openingStrategy.review(candle);
		closingStrategy.review(candle);

		if (order != null) {
			decideClose(candle);
		} else {
			decideOpen(candle);
		}
	}

	private void decideOpen(Candle candle) {
		OpeningDecision decision = openingStrategy.decide();

		if (!OpeningDecision.NONE.equals(decision)) {
			order = orderFactory.build(decision, candle.getClose(), candle.getTime());
		}
	}

	private void decideClose(Candle candle) {
		ClosingDecision decision = closingStrategy.decide(order);

		if (ClosingDecision.CLOSE.equals(decision)) {
			order.setExitPrice(candle.getClose());
			order.setExitTime(candle.getTime());
			orderHistory.add(order);

			calculateBalance();

			order = null;
		}
	}

	private void calculateBalance() {
		double profitLoss = order.getExitPrice() - order.getEntryPrice();

		if (OrderSide.SHORT.equals(order.getSide())) {
			profitLoss = profitLoss * -1;
		}

		double newBalance = balance + profitLoss;

		balanceObservers.stream().forEach(o -> o.balanceChanged(balance, newBalance));

		balance = newBalance;
	}

	public static void main(String[] args) {
		BtcTrader btcTrader = new BtcTrader();
		btcTrader.trade(LocalDateTime.of(2016, 01, 01, 0, 0), Period.ofDays(100), ChronoUnit.HOURS, Product.BTCEUR);
	}
}
