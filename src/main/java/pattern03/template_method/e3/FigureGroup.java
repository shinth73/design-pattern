package pattern03.template_method.e3;

import java.util.ArrayList;
import java.util.List;

public class FigureGroup extends Figure {
    private List<Figure> figures = new ArrayList<Figure>();

    @Override
    public void move() {
        for (Figure figure : figures)
            figure.move();
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        FigureGroup group = new FigureGroup();
        for (Figure figure : figures)
            group.add(figure.clone());
        return group;
    }

    @Override
    public void drawFigure(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sGroup(\n", padding);
        for (Figure figure : figures)
            figure.draw(indent + 1);
        System.out.printf("%s)\n", padding);
    }

    public void add(Figure f) {
        figures.add(f);
    }

    public int getCount() { return figures.size(); }
    public Figure get(int index) { return figures.get(index); }
}