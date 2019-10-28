package btctrader.strategy.open;

import java.util.ArrayDeque;

import btctrader.data.Candle;

public class SmaOpeningStrategy implements OpeningStrategy{

	private ArrayDeque<Candle> candles = new ArrayDeque<>();

	@Override
	public void review(Candle candle) {
		candles.add(candle);
		if (candles.size() > 20) {
			candles.poll();
		}
	}

	@Override
	public OpeningDecision decide() {
		double  sma = 0;
		
		for(Candle c : candles) {
			sma += c.getClose();
		}
		sma /= candles.size();
		
		if (sma < candles.getLast().getClose() * 0.9) {
			return OpeningDecision.BUY;
		} else if(sma > candles.getLast().getClose() * 1.1) {
			return OpeningDecision.SELL;
		} else {
			return OpeningDecision.NONE;
		}
	}
}
