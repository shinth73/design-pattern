package pattern03.builder.e3;

import java.io.IOException;
import java.io.Writer;

public class HtmlBuilder {

	private Writer writer;

	public HtmlBuilder(Writer writer) {
		this.writer = writer;
	}

	public void beginTable() throws IOException {
		writer.write("<table>\n");
	}

	public void beginRecord() throws IOException {
		writer.write("<tr>");
	}

	public void write(Object value) throws IOException {
		writer.write("<td>");
		writer.write(value.toString());
		writer.write("</td>");
	}

	public void closeRecord() throws IOException {
		writer.write("</tr>\n");
	}

	public void closeTable() throws IOException {
		writer.write("</table>\n");
	}
}
