package pattern01.composite.f2;

public abstract class Figure implements Cloneable {

    public abstract void draw(int indent);
    public abstract void move(int dx, int dy);

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure)super.clone();
    }
}
