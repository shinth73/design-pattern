package pattern03.builder.e3;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

public class CsvBuilder {

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

    public void write(Object value) throws IOException {
    	if (newLine)
    		newLine = false;
    	else
    		writer.write(",");

    	if (isPrimitive(value))
    		writer.write(value.toString());
    	else {
    		writer.write("\"");
    		writer.write(value.toString().replace("\"", "\\\""));
    		writer.write("\"");
    	}
    }

    public void closeLine() throws IOException {
    	writer.write("\n");
    	newLine = true;
    }

}