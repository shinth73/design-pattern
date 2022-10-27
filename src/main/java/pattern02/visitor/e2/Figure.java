package pattern02.visitor.e2;

public abstract class Figure implements Cloneable {
    int value;

    public Figure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract void draw(int indent);

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure)super.clone();
    }

    public abstract void accept(Visitor visitor);
}
