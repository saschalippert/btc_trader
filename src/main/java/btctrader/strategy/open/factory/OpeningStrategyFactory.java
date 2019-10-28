package btctrader.strategy.open.factory;

import btctrader.strategy.open.OpeningStrategy;
import btctrader.strategy.open.SmaOpeningStrategy;
import btctrader.strategy.open.RandomOpeningStrategy;

public class OpeningStrategyFactory {

	public static OpeningStrategy buildOpeningStrategy(OpeningStrategyType openingStrategyType) {
		
	        OpeningStrategy openingStrategy = null;
	        switch (openingStrategyType) {
	        case RANDOM:
	            openingStrategy = new RandomOpeningStrategy();
	            break;
	
	        case SMA:
	        	openingStrategy = new SmaOpeningStrategy();
	            break;
	            
	        default:
	            // throw some exception
	            break;
	        }
	        return openingStrategy;
	    }
}
