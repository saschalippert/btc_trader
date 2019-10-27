package btctrader.order;

import java.time.LocalDateTime;

import btctrader.strategy.open.OpeningDecision;

public interface OrderFactory {
	public Order build(OpeningDecision decision, double price, LocalDateTime time);
}
