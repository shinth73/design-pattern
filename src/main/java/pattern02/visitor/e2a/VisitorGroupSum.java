package pattern02.visitor.e2a;

public class VisitorGroupSum implements Visitor {
    int lineSum = 0;
    int rectangleSum = 0;
    int groupSum = 0;


    @Override
    public void visit(Rectangle rectangle) {
        rectangleSum += rectangle.value;
    }

    @Override
    public void visit(Line line) {
        lineSum += line.value;
    }

    @Override
    public void visit(FigureGroup group) {
        groupSum += group.value;
    }

    @Override
    public String toString() {
        return String.format("line=%d rectangle=%d group=%d\n",
                lineSum, rectangleSum, groupSum);
    }
}
