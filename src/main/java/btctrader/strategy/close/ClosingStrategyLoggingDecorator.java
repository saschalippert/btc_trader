package btctrader.strategy.close;

import btctrader.data.Candle;
import btctrader.order.Order;

public class ClosingStrategyLoggingDecorator implements ClosingStrategy {

	ClosingStrategy closingStrategy;

	public ClosingStrategyLoggingDecorator(ClosingStrategy closingStrategy) {
		super();
		this.closingStrategy = closingStrategy;
	}

	@Override
	public void review(Candle candle) {
		closingStrategy.review(candle);
	}

	@Override
	public ClosingDecision decide(Order order) {
		ClosingDecision closingDecision = closingStrategy.decide(order);
		
		System.out.println(closingDecision);
		
		return closingDecision;
	}

}
