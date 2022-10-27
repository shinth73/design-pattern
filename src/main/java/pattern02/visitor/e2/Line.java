package pattern02.visitor.e2;

public class Line extends Figure {
    String label;

    public Line(int value) {
        super(value);
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sLine(%d)\n", padding, value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
