package pattern01.iterator.e7;

public interface MyCollection {
    void add(int value);
    MyIterator getIterator();
    MyIterator getReverseIterator();
}
