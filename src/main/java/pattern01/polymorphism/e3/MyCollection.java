package pattern01.polymorphism.e3;

public interface MyCollection {
    void add(int value);
    MyIterator getIterator();

    default void addAll(MyCollection col) {
        MyIterator it = col.getIterator();
        while (!it.isEnd())
            add(it.getNext());
    }
}
