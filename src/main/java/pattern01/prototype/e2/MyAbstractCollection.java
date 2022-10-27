package pattern01.prototype.e2;

public abstract class MyAbstractCollection implements MyCollection {

    @Override
    public void addAll(MyCollection col) {
        MyIterator it = col.getIterator();
        while (!it.isEnd())
            add(it.getNext());
    }

    protected abstract MyCollection createInstance();

    @Override
    public MyCollection clone() {
        MyCollection col = createInstance();
        col.addAll(this);
        return col;
    }
}
