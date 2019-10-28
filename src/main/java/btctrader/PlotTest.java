package btctrader;

import java.io.IOException;
import java.io.InputStream;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.OHLCPlot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;

public class PlotTest {

	public static void main(String[] args) throws IOException {		
		InputStream is = PlotTest.class.getClassLoader().getResourceAsStream("bush.csv");
		Table bush = Table.read().csv(is);
		Table foxOnly = bush.where(bush.stringColumn("who").equalsIgnoreCase("fox"));
		Plot.show(TimeSeriesPlot.create("Fox approval ratings", foxOnly, "date", "approval"));
		
		
		int[] x = {1, 2, 3};
		double[] y = {90.1, 84.3, 99.7};

		Table function =
		    Table.create("Function")
		        .addColumns(
		            IntColumn.create("x", x),
		            DoubleColumn.create("y", y));
		
		
		Plot.show(TimeSeriesPlot.create(function.name(), function, "x", "y"));
		
		is = PlotTest.class.getClassLoader().getResourceAsStream("ohlcdata.csv");
		
		Table priceTable = Table.read().csv(is);
		
		Plot.show(OHLCPlot.create("Prices", 	// The plot title 
                priceTable, 	// the table we loaded earlier
                "date",		// our time variable
                "open", 		// the price data...
                "high", 
                "low", 
                "close"));
	}

}
