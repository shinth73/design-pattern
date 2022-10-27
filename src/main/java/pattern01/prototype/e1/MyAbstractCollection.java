package pattern01.prototype.e1;

public abstract class MyAbstractCollection implements MyCollection {

    @Override
    public void addAll(MyCollection col) {
        MyIterator it = col.getIterator();
        while (!it.isEnd())
            add(it.getNext());
    }

    @Override
    public MyCollection clone() throws CloneNotSupportedException {
        return (MyAbstractCollection)super.clone();
    }

}
