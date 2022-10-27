package pattern03.builder.e4a;

import java.io.IOException;

public interface MyBuilder {
	void beginTable() throws IOException;
	void beginRecord() throws IOException;
	void write(Object value) throws IOException;
	void closeRecord() throws IOException;
	void closeTable() throws IOException;
}
