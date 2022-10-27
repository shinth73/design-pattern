package pattern02.visitor.e2;

public class VisitorMax implements Visitor {
    int max = Integer.MIN_VALUE;

    @Override
    public void visit(Rectangle rectangle) {
        max = Math.max(max, rectangle.getValue());
    }

    @Override
    public void visit(Line line) {
        max = Math.max(max, line.getValue());
    }

    @Override
    public void visit(FigureGroup group) {
        max = Math.max(max, group.getValue());
    }

    @Override
    public String toString() {
        return String.format("max=%d\n", max);
    }

}
