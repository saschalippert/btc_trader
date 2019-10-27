package btctrader;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import btctrader.data.Candle;
import btctrader.data.History;
import btctrader.data.Product;
import btctrader.data.handler.DataHandler;
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

	public void trade(LocalDateTime start, Duration duration, Period period, Product product) {
		History history = dataHandler.load(start, duration, period, product);
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
		order = orderFactory.build(decision, candle.getClose(), candle.getTime());
	}

	private void decideClose(Candle candle) {
		ClosingDecision decision = closingStrategy.decide(order);
		
		if(ClosingDecision.CLOSE.equals(decision)) {
			order.setExit(candle.getClose());
			order.setExitTime(candle.getTime());
			orderHistory.add(order);
			
			double profitLoss = order.getExit() - order.getEntry();
			
			if(OrderSide.SHORT.equals(order.getSide())) {
				profitLoss = profitLoss * -1;
			}
			
			balance += profitLoss;
			
			LOGGER.info("profitLoss " + profitLoss);
			LOGGER.info("new balance " + balance);
			
			order = null;
		}
	}

	public static void main(String[] args) {
		LOGGER.info("Hello World");
	}
}
