package btctrader.strategy.close;

import java.util.Random;

import org.springframework.stereotype.Component;

import btctrader.data.Candle;
import btctrader.order.Order;

@Component
public class RandomClosingStrategy implements ClosingStrategy {

	Random random = new Random();

	@Override
	public void review(Candle candle) {
		// TODO Auto-generated method stub
	}

	@Override
	public ClosingDecision decide(Order order) {
		int v = random.nextInt(2);
		return ClosingDecision.values()[v];
	}
}
