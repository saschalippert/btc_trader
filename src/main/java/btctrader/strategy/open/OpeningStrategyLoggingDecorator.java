package btctrader.strategy.open;

import btctrader.data.Candle;

public class OpeningStrategyLoggingDecorator implements OpeningStrategy {

	OpeningStrategy openingStrategy;

	public OpeningStrategyLoggingDecorator(OpeningStrategy openingStrategy) {
		super();
		this.openingStrategy = openingStrategy;
	}

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
