package pattern02.visitor.e1a;

public abstract class Figure implements Cloneable {
    int value;

    public Figure(int value) {
        this.value = value;
    }

    public abstract void draw(int indent);

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure)super.clone();
    }

    public int max() {
        return value;
    }

    public int sum() {
        return value;
    }

    public abstract void count(CountResult result);
    public abstract void groupSum(GroupSumResult result);
}
