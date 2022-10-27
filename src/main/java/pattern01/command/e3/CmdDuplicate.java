package pattern01.command.e3;

import java.util.List;

class CmdDuplicate implements Command {
    List<Figure> figures;
    int index1, index2;

    CmdDuplicate(List<Figure> figures, int index) {
        this.figures = figures;
        this.index1 = index;
    }

    @Override
    public void execute() {
        try {
            Figure figure = figures.get(index1);
            figures.add(figure.clone());
            index2 = figures.size() - 1;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        figures.remove(index2);
    }
}