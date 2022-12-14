package pattern02.visitor.e2a;

import java.util.Scanner;

public class Example2a {

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
            Visitor visitor = null;
            String[] a = cmd.split(" +");
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
                root.accept(visitor = new VisitorMax());
                System.out.println(visitor);
                break;
            case "sum":
                root.accept(visitor = new VisitorSum());
                System.out.println(visitor);
                break;
            case "count":
                root.accept(visitor = new VisitorCount());
                System.out.println(visitor);
                break;
            case "groupsum":
                root.accept(visitor = new VisitorGroupSum());
                System.out.println(visitor);
                break;
            case "quit": System.exit(0); break;
            }
        } catch (Exception e) {
        }
    }

    static void prompt() {
        System.out.printf("  ?????????  : rectangle ??????\n");
        System.out.printf("  ???      : line ??????\n");
        System.out.printf("  ??????    : remove ??????\n");
        System.out.printf("  ??????    : duplicate ??????\n");
        System.out.printf("  ??????    : group ??????1, ??????2,...\n");
        System.out.printf("  ?????????  : max\n");
        System.out.printf("  ??????    : sum\n");
        System.out.printf("  ?????? ??? : count\n");
        System.out.printf("  ????????????: groupsum\n");
        System.out.printf("  ??????    : quit\n");
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
