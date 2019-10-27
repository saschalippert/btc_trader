package btctrader.data.handler;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class DataHandlerCoinBase {

	private static final String REST_URI = "https://api.pro.coinbase.com/products/BTC-EUR/candles";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		List<List<String>> result = client.target(REST_URI)
				.property("start", "2019-08-20")
				.property("end", "2019-08-21")
				.property("granularity", "3600")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<List<String>>>() {});

		for (List<String> list : result) {
			System.out.println(list);
		}
	}
}
