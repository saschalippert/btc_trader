package btctrader.strategy.open;

import java.util.Random;

import btctrader.data.Candle;

public class RandomOpeningStrategy implements OpeningStrategy{

	@Override
	public void review(Candle candle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OpeningDecision decide() {
		int randInt = new Random().nextInt(3);
		return OpeningDecision.values()[randInt];
	}
}
