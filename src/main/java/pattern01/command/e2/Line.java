package pattern01.command.e2;

public class Line extends Figure {
    int x, y;
    String label;

    public Line(String label) {
        this.label = label;
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sLine(%s, %d, %d)\n", padding, label, x, y);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx; y += dy;
    }
}
