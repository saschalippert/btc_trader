package btctrader.order;

import java.time.LocalDateTime;

public class Order {
	private OrderSide side;

	private double entry;

	private double exit;

	private LocalDateTime entryTime;

	private LocalDateTime exitTime;

	public Order(OrderSide side, double entry, LocalDateTime entryTime) {
		super();
		this.side = side;
		this.entry = entry;
		this.entryTime = entryTime;
	}

	public OrderSide getSide() {
		return side;
	}

	public void setSide(OrderSide side) {
		this.side = side;
	}

	public double getEntry() {
		return entry;
	}

	public void setEntry(double entry) {
		this.entry = entry;
	}

	public double getExit() {
		return exit;
	}

	public void setExit(double exit) {
		this.exit = exit;
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
