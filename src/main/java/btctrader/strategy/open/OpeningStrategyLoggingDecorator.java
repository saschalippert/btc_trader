package btctrader.strategy.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import btctrader.data.Candle;

@Component
public class OpeningStrategyLoggingDecorator implements OpeningStrategy {

	@Autowired
	OpeningStrategy openingStrategy;

	@Override
	public void review(Candle candle) {
		openingStrategy.review(candle);
	}

	@Override
	public OpeningDecision decide() {
		OpeningDecision openingDecision = openingStrategy.decide();

		System.out.println(openingDecision);

		return openingDecision;
	}

}
