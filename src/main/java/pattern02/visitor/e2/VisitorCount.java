package pattern02.visitor.e2;

public class VisitorCount implements Visitor {
    int lineCount = 0;
    int rectangleCount = 0;
    int groupCount = 0;


    @Override
    public void visit(Rectangle rectangle) {
        ++rectangleCount;
    }

    @Override
    public void visit(Line line) {
        ++lineCount;
    }

    @Override
    public void visit(FigureGroup group) {
        ++groupCount;
    }

    @Override
    public String toString() {
        return String.format("line=%d rectangle=%d group=%d\n",
                lineCount, rectangleCount, groupCount);
    }
}
