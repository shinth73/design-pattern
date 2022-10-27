package pattern01.command.e2;

import java.util.ArrayList;
import java.util.List;

public class FigureGroup extends Figure {
    private List<Figure> figures = new ArrayList<Figure>();

    @Override
    public Figure clone() throws CloneNotSupportedException {
        FigureGroup group = new FigureGroup();
        for (Figure figure : figures)
            group.add(figure.clone());
        return group;
    }

    @Override
    public void draw(int indent) {
        String padding = "  ".repeat(indent);
        System.out.printf("%sGroup(\n", padding);
        for (Figure figure : figures)
            figure.draw(indent + 1); // 그룹 내부 도형 1 칸 들여쓰기
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

    @Override
    public void move(int dx, int dy) {
        for (Figure figure : figures)
            figure.move(dx,  dy);
    }
}