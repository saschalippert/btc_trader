package btctrader.data.builder;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import btctrader.data.Candle;
import btctrader.data.History;
import btctrader.data.Product;

public class DataBuilderHistory {

	private final LocalDateTime start;
	private final Period delta;
	private final ChronoUnit aggregation;
	private final Product product;
	private final List<Candle> candles = new ArrayList<Candle>();

	public DataBuilderHistory(LocalDateTime start, Period delta, ChronoUnit aggregation, Product product) {
		super();
		this.start = start;
		this.delta = delta;
		this.aggregation = aggregation;
		this.product = product;
	}

	public DataBuilderHistory addCandle(Candle candle) {
		candles.add(candle);

		return this;
	}

	public History build() {
		return new History(start, delta, aggregation, product, candles);
	}

}
