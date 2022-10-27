package pattern03.template_method.e3;

public abstract class Figure implements Cloneable {
    int x, y;
    boolean _handle, _shadow;

    public Figure() {
        _handle = false;
        _shadow = false;
    }

    public void move() {
        x += 10;
        y += 10;
    }

    public boolean isHandled() {
        return _handle;
    }

    public boolean isShadowed() {
        return _shadow;
    }

    public void setHandle(boolean value) {
        _handle = value;
    }

    public void setShadow(boolean value) {
        _shadow = value;
    }

    public abstract void drawFigure(int indent);

    public void draw(int indent) {
        drawFigure(indent);
        if (_handle)
            drawHandle(indent);
        if (_shadow)
            drawShadow(indent);
    }

    public void drawHandle(int indent) {
        System.out.printf("%s Handle %d %d\n", "  ".repeat(indent), x, y);
    }

    public void drawShadow(int indent) {
        System.out.printf("%s Shadow %d %d\n", "  ".repeat(indent), x, y);
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Figure) super.clone();
    }
}
