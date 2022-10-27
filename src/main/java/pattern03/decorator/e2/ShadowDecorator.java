package pattern03.decorator.e2;

public class ShadowDecorator extends Decorator {

    public ShadowDecorator(Figure figure) {
        super(figure);
    }

    @Override
    public void draw(int indent) {
        figure.draw(indent); // 먼저 도형을 그리고
        System.out.printf("%s Shadow %d %d\n", "  ".repeat(indent), x, y); // 그 다음 decorator를 그린다
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return new ShadowDecorator(figure.clone());
    }
}
