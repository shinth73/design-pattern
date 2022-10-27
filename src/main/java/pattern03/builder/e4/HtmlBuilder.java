package pattern03.builder.e4;

import java.io.IOException;
import java.io.Writer;

public class HtmlBuilder implements MyBuilder {

	private Writer writer;

	public HtmlBuilder(Writer writer) {
		this.writer = writer;
	}

	@Override
    public void beginTable() throws IOException {
		writer.write("<table>\n");
	}

	@Override
    public void beginRecord() throws IOException {
		writer.write("<tr>");
	}

	@Override
    public void write(Object value) throws IOException {
		writer.write("<td>");
		writer.write(value.toString());
		writer.write("</td>");
	}

	@Override
    public void closeRecord() throws IOException {
		writer.write("</tr>\n");
	}

	@Override
    public void closeTable() throws IOException {
		writer.write("</table>\n");
	}
}
