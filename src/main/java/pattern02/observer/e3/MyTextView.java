package pattern02.observer.e3;

public class MyTextView extends MyView {

    public MyTextView(MyIntDocument doc) {
        super(doc);
    }

    @Override
    public void draw() {
        int data = ((MyIntDocument)document).getData();
        System.out.printf("View1: %d\n", data);
    }
};
