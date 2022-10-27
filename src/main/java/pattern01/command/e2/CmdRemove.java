package pattern01.command.e2;

import java.util.List;

class CmdRemove implements Command {
    List<Figure> figures; // 전체 도형 목록
    int index;            // remove 할 위치
    Figure figure;        // remove 된 도형

    CmdRemove(List<Figure> figures, int index) {
        this.index = index;
        this.figures = figures;
    }

    @Override
    public void execute() {
        figure = figures.remove(index);
    }

    @Override
    public void undo() {
        figures.add(index, figure);
    }
};