package pattern01.command.e2;

public class CmdMove implements Command {
    Figure figure; // 이동할 도형
    int dx, dy; // 이동 거리

    public CmdMove(Figure figure, int dx, int dy) {
        this.figure = figure;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        figure.move(dx, dy);
    }

    @Override
    public void undo() {
        figure.move(-dx, -dy);
    }

}
