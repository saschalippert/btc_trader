package btctrader.data.handler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import btctrader.data.History;
import btctrader.data.Product;

public interface DataHandler {
	public History load(LocalDateTime start, Duration duration, Period period, Product product);
	
	public void save(History history);
}
