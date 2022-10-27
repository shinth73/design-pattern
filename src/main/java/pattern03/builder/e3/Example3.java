package pattern03.builder.e3;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Example3 {

	static void printCsv(Writer writer, Object[][] data) throws IOException {
		CsvBuilder builder = new CsvBuilder(writer);
		for (Object[] record : data) {
			for (Object field : record)
				builder.write(field);
			builder.closeLine();
		}
	}

	static void printHtml(Writer writer, Object[][] data) throws IOException {
		HtmlBuilder builder = new HtmlBuilder(writer);
		builder.beginTable();
		for (Object[] record : data) {
			builder.beginRecord();
			for (Object field : record)
				builder.write(field);
			builder.closeRecord();
		}
		builder.closeTable();
	}

	public static void main(String[] args) throws IOException {
		Object[][] data = {
				{ "tom", 24, "910614-1488111", "02-333-4444" },
				{ "john", 28, "870320-1434123", "02-444-5555" },
				{ "smith", 25, "901105-1300234", "02-555-6666" }
		};
		Writer writer = new PrintWriter(System.out, true);
		printCsv(writer, data);
		printHtml(writer, data);
		writer.close();
	}

}
