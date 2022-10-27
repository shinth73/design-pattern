package pattern02.observer.e2;

public class MyGraphView implements Observer {
    MyIntDocument document;

    public MyGraphView(MyIntDocument doc) {
        document = doc;
        document.addObserver(this);
    }

    public void draw() {
        int data = document.getData();
        System.out.printf("View2: ");
        for (int i = 0; i < data; ++i)
            System.out.print('*');
        System.out.print('\n');
    }

    @Override
    public void update(Observable observable) {
        draw();
    }
}
