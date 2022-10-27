package pattern03.builder.e4a;

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
        String s = value.toString();
        s = s.replaceAll("([0-9]{6})-[0-9]{7}", "$1-*******");
		writer.write("<td>");
		writer.write(s);
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
