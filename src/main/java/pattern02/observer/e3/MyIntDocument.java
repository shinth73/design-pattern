package pattern02.observer.e3;

public class MyIntDocument extends MyDocument {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        data = i;
        updateAllViews();
    }
}