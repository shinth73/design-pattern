package pattern01.command.e2;

import java.util.List;

class CmdDuplicate implements Command {
    List<Figure> figures; // 전체 도형 목록
    int index1, index2;  // 복제할 도형의 index, 복제된 도형의 index

    CmdDuplicate(List<Figure> figures, int index) {
        this.figures = figures;
        this.index1 = index;
    }

    @Override
    public void execute() {
        try {
            Figure figure = figures.get(index1);
            figures.add(figure.clone()); // 복제
            index2 = figures.size() - 1; // 복제된 도형의 위치 기록
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        figures.remove(index2);
    }
}