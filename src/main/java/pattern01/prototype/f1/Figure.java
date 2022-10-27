package pattern01.prototype.f1;

public abstract class Figure implements Cloneable {

    public abstract void draw();

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure)super.clone();
    }
}
