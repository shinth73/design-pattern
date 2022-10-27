package pattern03.decorator.i1;

public interface MyCollection {
    void add(MyObject value);
    boolean contains(MyObject value);
    MyIterator getIterator();
    MyIterator getReverseIterator();
}

