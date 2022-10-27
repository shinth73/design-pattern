package pattern03.builder.e4a;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

public class CsvBuilder implements MyBuilder {

	private static Set<Class<?>> primitiveTypes = new HashSet<Class<?>>();
	private boolean newLine = true;
	private Writer writer;

	public CsvBuilder(Writer writer) {
		this.writer = writer;
	}

	static {
		primitiveTypes.add(Boolean.class);
		primitiveTypes.add(Character.class);
		primitiveTypes.add(Byte.class);
		primitiveTypes.add(Short.class);
		primitiveTypes.add(Integer.class);
		primitiveTypes.add(Long.class);
		primitiveTypes.add(Float.class);
		primitiveTypes.add(Double.class);
	}

	private static boolean isPrimitive(Object value) {
		return primitiveTypes.contains(value.getClass());
	}

    @Override
    public void write(Object value) throws IOException {
    	if (newLine)
    		newLine = false;
    	else
    		writer.write(",");

    	if (isPrimitive(value))
    		writer.write(value.toString());
    	else {
    	    String s = value.toString();
    	    s = s.replaceAll("([0-9]{6})-[0-9]{7}", "$1-*******");

    		writer.write("\"");
    		writer.write(s.replace("\"", "\\\""));
    		writer.write("\"");
    	}
    }

	@Override
    public void closeRecord() throws IOException {
    	writer.write("\n");
    	newLine = true;
    }

	@Override
	public void beginTable() throws IOException {
	}

	@Override
	public void beginRecord() throws IOException {
	}

	@Override
	public void closeTable() throws IOException {
	}

}