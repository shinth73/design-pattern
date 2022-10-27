package pattern02.visitor.e2;

public class Rectangle extends Figure {

    public Rectangle(int value) {
        super(value);
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sRectangle(%d)\n", padding, value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
