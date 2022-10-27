package pattern01.command.e2;

import java.util.Collections;
import java.util.List;

public class CmdGroup implements Command {
    List<Figure> figures; // 전체 도형 목록
    List<Integer> indexes; // 그룹으로 묶을 도형 목록
    FigureGroup group;     // 생성된 그룹
    int index;             // 생성된 그룹의 위치

    public CmdGroup(List<Figure> figures, List<Integer> indexes) {
        this.figures = figures;
        this.indexes = indexes;
    }

    @Override
    public void execute() {
        Collections.sort(indexes); // undo 구현을 위해 정렬함
        group = new FigureGroup();
        for (int index : indexes)
            group.add(figures.get(index));
        figures.add(group);
        index = figures.size() - 1; // 생성된 그룹위 위치 기록
        for (int i = 0; i < group.getCount(); ++i)
            figures.remove(group.get(i));
    }

    @Override
    public void undo() {
        for (int i = 0; i < indexes.size(); ++i)
            figures.add(indexes.get(i), group.get(i));
        figures.remove(index);
    }
}
