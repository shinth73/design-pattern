package pattern03.decorator.i2;

public interface MyCollection {
    void add(MyObject value);
    boolean contains(MyObject value);
    MyIterator getIterator();
    MyIterator getReverseIterator();
}

