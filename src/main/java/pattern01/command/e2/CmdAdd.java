package pattern01.command.e2;

import java.util.List;

class CmdAdd implements Command {
    List<Figure> figures; // 전체 도형 목록
    Figure figure; // add 할 도형
    int index;     // add 한 위치

    CmdAdd(List<Figure> figures, Figure figure) {
        this.figures = figures;
        this.figure = figure;
    }

    @Override
    public void execute() {
        figures.add(figure);   // 도형을 목록에 add 한다
        index = figures.size() - 1; // add 한 위치 기록
    }

    @Override
    public void undo() {
        figures.remove(index);
    }
};