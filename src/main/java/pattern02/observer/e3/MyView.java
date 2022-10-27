package pattern02.observer.e3;

abstract class MyView implements Observer {
    protected MyDocument document;

    public MyView(MyDocument doc) {
        document = doc;
        doc.addObserver(this);
    }

    public abstract void draw();

    @Override
    public void update(Observable observable) {
        draw();
    }
}