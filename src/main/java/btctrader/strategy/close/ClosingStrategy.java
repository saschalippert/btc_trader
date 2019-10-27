package btctrader.strategy.close;

import btctrader.data.Candle;
import btctrader.order.Order;

public interface ClosingStrategy {
	public void review(Candle candle);
	
	public ClosingDecision decide(Order order);
}
