package btctrader.data;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class History {
	private final LocalDateTime start;
	private final Period delta;
	private final ChronoUnit aggregation;
	private final Product product;
	private final List<Candle> candles;

	public History(LocalDateTime start, Period delta, ChronoUnit aggregation,
			Product product, List<Candle> candles) {
		super();
		this.start = start;
		this.delta = delta;
		this.aggregation = aggregation;
		this.product = product;
		this.candles = candles;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public Period getDelta() {
		return delta;
	}

	public ChronoUnit getAggregation() {
		return aggregation;
	}

	public Product getProduct() {
		return product;
	}

	public List<Candle> getCandles() {
		return Collections.unmodifiableList(candles);
	}
}
