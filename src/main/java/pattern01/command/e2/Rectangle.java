package pattern01.command.e2;

public class Rectangle extends Figure {
    int x, y;
    String label;

    public Rectangle(String label) {
        this.label = label;
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sRectangle(%s %d %d)\n", padding, label, x, y);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx; y += dy;
    }
}
