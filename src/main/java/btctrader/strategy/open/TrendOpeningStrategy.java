package btctrader.strategy.open;

import btctrader.data.Candle;

public class TrendOpeningStrategy implements OpeningStrategy {

	Candle oldCandle;
	Candle newCandle;

	@Override
	public void review(Candle candle) {
		oldCandle = newCandle;
		newCandle = candle;
	}

	@Override
	public OpeningDecision decide() {

		if (oldCandle != null && newCandle != null) {
			double diffClose = newCandle.getClose() - oldCandle.getClose();

			if (diffClose > 0) {
				return OpeningDecision.BUY;
			} else if (diffClose < 0) {
				return OpeningDecision.SELL;
			}
		}

		return OpeningDecision.NONE;
	}
}
