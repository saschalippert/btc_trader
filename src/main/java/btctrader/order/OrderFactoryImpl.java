package btctrader.order;

import java.time.LocalDateTime;

import btctrader.strategy.open.OpeningDecision;

public class OrderFactoryImpl implements OrderFactory {

	@Override
	public Order build(OpeningDecision decision, double price, LocalDateTime time) {

		if (OpeningDecision.BUY.equals(decision)) {
			return new Order(OrderSide.LONG, price, time);
		} else if (OpeningDecision.SELL.equals(decision)) {
			return new Order(OrderSide.SHORT, price, time);
		}

		return null;
	}

}
