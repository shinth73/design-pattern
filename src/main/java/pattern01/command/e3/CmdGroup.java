package pattern01.command.e3;

import java.util.Collections;
import java.util.List;

public class CmdGroup implements Command {
    List<Figure> figures;
    List<Integer> indexes;
    FigureGroup group;
    int index;

    public CmdGroup(List<Figure> figures, List<Integer> indexes) {
        this.figures = figures;
        this.indexes = indexes;
    }

    @Override
    public void execute() {
        Collections.sort(indexes);
        group = new FigureGroup();
        for (int index : indexes)
            group.add(figures.get(index));
        for (int i = 0; i < group.getCount(); ++i)
            figures.remove(group.get(i));
        figures.add(group);
        index = figures.size() - 1;
    }

    @Override
    public void undo() {
        figures.remove(index);
        for (int i = 0; i < indexes.size(); ++i)
            figures.add(indexes.get(i), group.get(i));
    }
}
