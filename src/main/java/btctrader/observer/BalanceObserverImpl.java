package btctrader.observer;

import java.util.ArrayList;
import java.util.List;

public class BalanceObserverImpl implements BalanceObserver {

	List<Double> balances = new ArrayList<Double>();

	@Override
	public void balanceChanged(double oldBalance, double newBalance) {

		if (balances.isEmpty()) {
			balances.add(oldBalance);
		}

		balances.add(newBalance);

		System.out.println("balance changed " + oldBalance + " -> " + newBalance);
	}

	public List<Double> getBalances() {
		return balances;
	}

}
