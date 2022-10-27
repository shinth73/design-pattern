package pattern03.template_method.e3;

public class Rectangle extends Figure {
    String label;

    public Rectangle(String label) {
        this.label = label;
    }

    @Override
    public void drawFigure(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sRectangle(%s, %d, %d)\n", padding, label, x, y);
    }
}
