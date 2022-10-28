package pattern02.visitor.e2a;

public class VisitorSum implements Visitor {
    int sum = 0;

    @Override
    public void visit(Rectangle rectangle) {
        sum += rectangle.getValue();
    }

    @Override
    public void visit(Line line) {
        sum += line.getValue();
    }

    @Override
    public void visit(FigureGroup group) {
        sum += group.getValue();
    }

    @Override
    public String toString() {
        return String.format("sum=%d\n", sum);
    }
}
