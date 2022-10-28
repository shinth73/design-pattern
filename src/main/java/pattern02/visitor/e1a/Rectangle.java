package pattern02.visitor.e1a;

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
    public void count(CountResult result) {
        result.rectangleCount++;
    }

    @Override
    public void groupSum(GroupSumResult count) {
        count.rectangleSum += this.value;
    }
}
