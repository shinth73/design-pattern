package pattern02.visitor.e2a;

import java.util.ArrayList;
import java.util.List;

public class FigureGroup extends Figure {

    public FigureGroup(int value) {
        super(value);
    }

    private List<Figure> figures = new ArrayList<Figure>();

    @Override
    public Figure clone() throws CloneNotSupportedException {
        FigureGroup group = new FigureGroup(value);
        for (Figure figure : figures)
            group.add(figure.clone());
        return group;
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sGroup(\n", padding);
        for (Figure figure : figures)
            figure.draw(indent + 1);
        System.out.printf("%s)\n", padding);
    }

    public void add(Figure f) {
        figures.add(f);
    }

    public int getCount() {
        return figures.size();
    }

    public Figure get(int index) {
        return figures.get(index);
    }

    public void remove(int index) {
        figures.remove(index);
    }

    public void remove(Figure figure) {
        figures.remove(figure);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Figure f : figures)
            f.accept(visitor);
    }

}