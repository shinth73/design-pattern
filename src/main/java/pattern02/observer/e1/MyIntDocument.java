package pattern02.observer.e1;

public class MyIntDocument {
    private int data;
    private MyTextView view1;
    private MyGraphView view2;

    public void setView1(MyTextView v) {
        view1 = v;
    }

    public void setView2(MyGraphView v) {
        view2 = v;
    }

    public int getData() {
        return data;
    }

    public void setData(int i) {
        data = i;
        view1.draw();
        view2.draw();
    }
}