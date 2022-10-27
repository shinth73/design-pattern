package pattern02.observer.e1;

public class MyTextView {
    public MyIntDocument document;

    public MyTextView(MyIntDocument doc) {
        document = doc;
    }

    public void draw() {
        int data = document.getData();
        System.out.printf("View1: %d\n", data);
    }
};
