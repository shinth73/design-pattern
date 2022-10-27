package pattern01.composite.f2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example2 {

    static List<Figure> figures = new ArrayList<Figure>();

    static void drawFigures() {
        System.out.println();
        for (int i = 0; i < figures.size(); ++i) {
            System.out.printf("%d: ", i);
            figures.get(i).draw(0);
        }
        System.out.println();
    }

    static void execute(String cmd) {
        try {
            String[] a = cmd.split("[, ]+");
            switch (a[0].toLowerCase()) {
            case "rectangle": figures.add(new Rectangle(a[1])); break;
            case "line": figures.add(new Line(a[1])); break;
            case "remove":
                int index = Integer.valueOf(a[1]);
                figures.remove(index);
                break;
            case "move":
                index = Integer.valueOf(a[1]);
                figures.get(index).move(2, 3);
                break;
            case "duplicate":
                Figure figure = figures.get(Integer.valueOf(a[1]));
                figures.add(figure.clone());
                break;
            case "group":
                FigureGroup group = new FigureGroup();
                for (int i = 1; i < a.length; ++i)
                    group.add(figures.get(Integer.valueOf(a[i])));
                figures.add(group);
                for (int i = 0; i < group.getCount(); ++i)
                    figures.remove(group.get(i));
                break;
            case "quit": System.exit(0); break;
            }
        } catch (Exception e) {
        }
    }

    static void prompt() {
        System.out.printf("  사각형 : rectangle 레이블\n");
        System.out.printf("  선     : line 레이블\n");
        System.out.printf("  삭제   : remove 번호\n");
        System.out.printf("  복제   : duplicate 번호\n");
        System.out.printf("  이동   : move 번호\n");
        System.out.printf("  그룹   : group 번호1, 번호2,...\n");
        System.out.printf("  종료   : quit\n");
        System.out.printf("  ? ");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                prompt();
                String cmd = scanner.nextLine();
                execute(cmd);
                drawFigures();
            }
        }
    }
}
