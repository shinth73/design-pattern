package pattern02.observer.e3;

public class MyDocument extends Observable {

    public void updateAllViews() {
        notifyObservers();
    }
}
