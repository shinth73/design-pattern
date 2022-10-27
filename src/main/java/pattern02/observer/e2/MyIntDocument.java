package pattern02.observer.e2;

public class MyIntDocument extends Observable {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        data = i;
        notifyObservers();
    }
}