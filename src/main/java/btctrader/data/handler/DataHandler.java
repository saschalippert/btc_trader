package btctrader.data.handler;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import btctrader.data.History;
import btctrader.data.Product;

public interface DataHandler {
	public History load(LocalDateTime start, Period delta, ChronoUnit aggregation, Product product);
}
