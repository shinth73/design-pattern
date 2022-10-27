package pattern02.visitor.e1;

public class CountResult {
    public int lineCount = 0;
    public int rectangleCount = 0;
    public int groupCount = 0;

    @Override
    public String toString() {
        return String.format("line=%d rectangle=%d group=%d\n",
                lineCount, rectangleCount, groupCount);
    }
}
