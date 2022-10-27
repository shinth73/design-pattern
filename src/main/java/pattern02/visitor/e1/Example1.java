package pattern02.visitor.e1;

import java.util.Scanner;

public class Example1 {

    static FigureGroup root = new FigureGroup(0);

    static void drawFigures() {
        System.out.println();
        for (int i = 0; i < root.getCount(); ++i) {
            System.out.printf("%d: ", i);
            root.get(i).draw(0);
        }
        System.out.println();
    }

    static void execute(String cmd) {
        try {
            CountResult countResult;
            String[] a = cmd.split("[, ]+");
            switch (a[0].toLowerCase()) {
            case "rectangle": root.add(new Rectangle(Integer.valueOf(a[1]))); break;
            case "line": root.add(new Line(Integer.valueOf(a[1]))); break;
            case "remove":
                int index = Integer.valueOf(a[1]);
                root.remove(index);
                break;
            case "duplicate":
                Figure figure = root.get(Integer.valueOf(a[1]));
                root.add(figure.clone());
                break;
            case "group":
                FigureGroup group = new FigureGroup(0);
                for (int i = 1; i < a.length; ++i)
                    group.add(root.get(Integer.valueOf(a[i])));
                root.add(group);
                for (int i = 0; i < group.getCount(); ++i)
                    root.remove(group.get(i));
                break;
            case "max":
                System.out.printf("max = %d\n", root.max());
                break;
            case "sum":
                System.out.printf("sum = %d\n", root.sum());
                break;
            case "count":
                countResult = new CountResult();
                root.count(countResult);
                System.out.println(countResult);
                break;
            case "quit": System.exit(0); break;
            default:
                System.out.println(a[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void prompt() {
        System.out.printf("  사각형 : rectangle 정수\n");
        System.out.printf("  선     : line 정수\n");
        System.out.printf("  삭제   : remove 번호\n");
        System.out.printf("  복제   : duplicate 번호\n");
        System.out.printf("  그룹   : group 번호1, 번호2,...\n");
        System.out.printf("  최대값 : max\n");
        System.out.printf("  합계   : sum\n");
        System.out.printf("  도형 수: count\n");
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
