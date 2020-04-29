package btctrader.strategy.close;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import btctrader.data.Candle;
import btctrader.order.Order;

@Component
public class ClosingStrategyLoggingDecorator implements ClosingStrategy {

	@Autowired
	@Qualifier("trendClosingStrategy")
	ClosingStrategy closingStrategy;

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
