package btctrader.strategy.open;

import btctrader.data.Candle;

public interface OpeningStrategy {
	public void review(Candle candle);
	
	public OpeningDecision decide();
}
