package btctrader.data;

import java.time.LocalDateTime;

public class Candle {
	private final LocalDateTime time;
	private final double low;
	private final double high;
	private final double open;
	private final double close;
	private final double volume;

	public Candle(LocalDateTime time, double low, double high, double open, double close, double volume) {
		super();
		this.time = time;
		this.low = low;
		this.high = high;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public double getLow() {
		return low;
	}

	public double getHigh() {
		return high;
	}

	public double getOpen() {
		return open;
	}

	public double getClose() {
		return close;
	}

	public double getVolume() {
		return volume;
	}

}
