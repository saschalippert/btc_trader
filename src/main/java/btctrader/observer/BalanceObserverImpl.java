package btctrader.observer;

public class BalanceObserverImpl implements BalanceObserver {

	@Override
	public void balanceChanged(double oldBalance, double newBalance) {
		System.out.println("balance changed " + oldBalance + " -> " + newBalance);
	}
}
