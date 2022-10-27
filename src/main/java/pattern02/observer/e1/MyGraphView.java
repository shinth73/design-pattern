package pattern02.observer.e1;

public class MyGraphView {
    MyIntDocument document;

    public MyGraphView(MyIntDocument doc) {
        document = doc;
    }

    public void draw() {
        int data = document.getData();
        System.out.printf("View2: ");
        for (int i = 0; i < data; ++i)
            System.out.print('*');
        System.out.print('\n');
    }
}