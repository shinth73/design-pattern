package pattern03.decorator.e2;

public abstract class Decorator extends Figure {
    Figure figure;

    public Decorator(Figure figure) {
        this.figure = figure;
        this.x = figure.getX(); // decorator는 figure 위치에 생성된다
        this.y = figure.getY();
    }

    @Override
    public void move() {
        x += 10; // 먼저 decorator가 이동하고
        y += 10;
        figure.move(); // 그 다음 figure도 이동한다
    }
}