package pattern02.observer.e1;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MyIntDocument doc = new MyIntDocument();
            MyTextView view1 = new MyTextView(doc);
            MyGraphView view2 = new MyGraphView(doc);
            doc.setView1(view1);
            doc.setView2(view2);

            for (;;) {
                int n;
                System.out.print("\n set document data (0 = quit) : ");
                n = scanner.nextInt();
                if (n <= 0)
                    break;
                doc.setData(n);
            }
        }
    }

}