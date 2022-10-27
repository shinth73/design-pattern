package pattern02.visitor.e2;

public interface Visitor {
    void visit(Rectangle rectangle);
    void visit(Line line);
    void visit(FigureGroup group);
}
