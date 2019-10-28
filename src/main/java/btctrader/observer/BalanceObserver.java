package btctrader.observer;

public interface BalanceObserver {
	public void balanceChanged(double oldBalance, double newBalance);
}
