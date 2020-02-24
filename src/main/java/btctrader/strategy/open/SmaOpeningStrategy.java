package btctrader.strategy.open;

import java.util.ArrayDeque;

import btctrader.data.Candle;

public class SmaOpeningStrategy implements OpeningStrategy{

	private ArrayDeque<Candle> candles = new ArrayDeque<>();

	@Override
	public void review(Candle candle) {
		
	}

	@Override
	public OpeningDecision decide() {
		return OpeningDecision.NONE;
	}
}
