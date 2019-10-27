package btctrader.data.handler;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import btctrader.data.handler.json.JsonCandle;

public class DataHandlerJsonFile {

	private final static String PATH = "btceur1h/btceur1h_2016_01_01.json";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		TypeReference<Map<String, JsonCandle>> typeRef = new TypeReference<Map<String, JsonCandle>>() {};
		Map<String, JsonCandle> candles = mapper.readValue(DataHandlerJsonFile.class.getClassLoader().getResourceAsStream(PATH), typeRef);
		System.out.println(candles);
	}
}
