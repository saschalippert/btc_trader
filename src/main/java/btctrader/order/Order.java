package btctrader.order;

import java.time.LocalDateTime;

public class Order {
	private OrderSide side;

	private double entryPrice;

	private double exitPrice;

	private LocalDateTime entryTime;

	private LocalDateTime exitTime;

	public Order(OrderSide side, double entry, LocalDateTime entryTime) {
		super();
		this.side = side;
		this.entryPrice = entry;
		this.entryTime = entryTime;
	}

	public OrderSide getSide() {
		return side;
	}

	public void setSide(OrderSide side) {
		this.side = side;
	}

	public double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(double entry) {
		this.entryPrice = entry;
	}

	public double getExitPrice() {
		return exitPrice;
	}

	public void setExitPrice(double exit) {
		this.exitPrice = exit;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
}
