package btctrader.strategy.close;

import org.springframework.stereotype.Component;

import btctrader.data.Candle;
import btctrader.order.Order;
import btctrader.order.OrderSide;

@Component
public class TrendClosingStrategy implements ClosingStrategy {

	Candle oldCandle;
	Candle newCandle;

	@Override
	public void review(Candle candle) {
		oldCandle = newCandle;
		newCandle = candle;
	}

	@Override
	public ClosingDecision decide(Order order) {

		if (oldCandle != null && newCandle != null) {
			double diffClose = newCandle.getClose() - oldCandle.getClose();

			if (diffClose > 0 && order.getSide().equals(OrderSide.SHORT)) {
				return ClosingDecision.CLOSE;
			} else if (diffClose < 0 && order.getSide().equals(OrderSide.LONG)) {
				return ClosingDecision.CLOSE;
			}
		}

		return ClosingDecision.HOLD;

	}
}
