package btctrader.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;
import java.util.List;

public class History {
	private final LocalDateTime start;
	private final Duration duration;
	private final Period period;
	private final Product product;
	private final List<Candle> candles;

	public History(LocalDateTime start, Duration duration, Period period, Product product, List<Candle> candles) {
		super();
		this.start = start;
		this.duration = duration;
		this.period = period;
		this.product = product;
		this.candles = candles;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public Duration getDuration() {
		return duration;
	}

	public Period getPeriod() {
		return period;
	}

	public Product getProduct() {
		return product;
	}

	public List<Candle> getCandles() {
		return Collections.unmodifiableList(candles);
	}
}
