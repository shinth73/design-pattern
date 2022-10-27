package pattern03.decorator.e2;

public abstract class Figure implements Cloneable {
    int x, y;

    public abstract void draw(int indent);

    public void move() {
        x += 10;
        y += 10;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure)super.clone();
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

}
