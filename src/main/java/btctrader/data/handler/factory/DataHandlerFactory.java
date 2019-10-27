package btctrader.data.handler.factory;

import btctrader.data.handler.DataHandler;

public interface DataHandlerFactory {
	public DataHandler build(DataSourceType dataSourceType);
}
