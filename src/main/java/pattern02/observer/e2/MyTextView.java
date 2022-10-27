package pattern02.observer.e2;

public class MyTextView implements Observer {
    public MyIntDocument document;

    public MyTextView(MyIntDocument doc) {
        document = doc;
        document.addObserver(this);
    }

    public void draw() {
        int data = document.getData();
        System.out.printf("View1: %d\n", data);
    }

    @Override
    public void update(Observable observable) {
        draw();
    }
};
