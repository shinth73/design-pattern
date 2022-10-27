package pattern03.template_method.e3;

public class Line extends Figure {
    String label;

    public Line(String label) {
        this.label = label;
    }

    @Override
    public void drawFigure(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sLine(%s, %d, %d)\n", padding, label, x, y);
    }
}
