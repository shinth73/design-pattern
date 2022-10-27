package pattern01.composite.e3;

public abstract class MyAbstractCollection implements MyCollection {

    @Override
    public void addAll(MyCollection col) {
        MyIterator it = col.getIterator();
        while (!it.isEnd())
            add(it.getNext());
    }

    @Override
    public MyCollection clone() throws CloneNotSupportedException {
        MyCollection col = null;
        try {
            col = this.getClass().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new CloneNotSupportedException();
        }
        col.addAll(this);
        return col;
    }
}
