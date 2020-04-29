package btctrader.data.handler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import btctrader.data.Candle;
import btctrader.data.History;
import btctrader.data.Product;
import btctrader.data.builder.DataBuilderHistory;
import btctrader.data.handler.json.JsonCandle;

@Component
public class DataHandlerJsonFile implements DataHandler {

	@Override
	public History load(LocalDateTime start, Period delta, ChronoUnit aggregation, Product product) {
		String prefix = product.name().toLowerCase();

		if (ChronoUnit.HOURS.equals(aggregation)) {
			prefix += "1h";
		}

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Map<String, JsonCandle>> typeRef = new TypeReference<Map<String, JsonCandle>>() {
		};

		LocalDateTime end = start.plus(delta);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
		
		DataBuilderHistory builderHistory = new DataBuilderHistory(start, delta, aggregation, product);

		for (LocalDateTime current = start; current.isBefore(end) || current.isEqual(end); current = current.plusDays(1)) {
			String dateString = current.format(formatter);
			String path = prefix + "/" + prefix + "_" + dateString + ".json";
			
			try {
				Map<String, JsonCandle> candles = mapper.readValue(DataHandlerJsonFile.class.getClassLoader().getResourceAsStream(path), typeRef);
				
				for (JsonCandle jsonCandle : candles.values()) {
					Instant instant = Instant.ofEpochSecond(jsonCandle.getTime());
					LocalDateTime time = LocalDateTime.ofInstant(instant, TimeZone.getTimeZone("GMT").toZoneId());
					Candle candle = new Candle(time, jsonCandle.getLow(), jsonCandle.getHigh(), jsonCandle.getOpen(), jsonCandle.getClose(), jsonCandle.getVolume());
					builderHistory.addCandle(candle);
				}
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		return builderHistory.build();
	}
}
