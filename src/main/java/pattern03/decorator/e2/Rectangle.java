package pattern03.decorator.e2;

public class Rectangle extends Figure {
    String label;

    public Rectangle(String label) {
        this.label = label;
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sRectangle(%s, %d, %d)\n", padding, label, x, y);
    }
}
