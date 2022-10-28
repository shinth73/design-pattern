package pattern02.visitor.e1a;

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
    public void count(CountResult count) {
        count.lineCount++;
    }

    @Override
    public void groupSum(GroupSumResult count) {
        count.lineSum += this.value;
    }

}
