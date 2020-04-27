package btctrader.strategy.open;

import btctrader.data.Candle;

public class RandomOpeningStrategy implements OpeningStrategy{

	@Override
	public void review(Candle candle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OpeningDecision decide() {
		return OpeningDecision.NONE;
	}
}
