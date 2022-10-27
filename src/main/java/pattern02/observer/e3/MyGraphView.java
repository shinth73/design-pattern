package pattern02.observer.e3;

public class MyGraphView extends MyView {

    public MyGraphView(MyIntDocument doc) {
        super(doc);
    }

    @Override
    public void draw() {
        int data = ((MyIntDocument)document).getData();
        System.out.printf("View2: ");
        for (int i = 0; i < data; ++i)
            System.out.print('*');
        System.out.print('\n');
    }
}