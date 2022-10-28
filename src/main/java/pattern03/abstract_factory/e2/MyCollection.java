package pattern03.abstract_factory.e2;

public interface MyCollection {
    void add(MyObject value);
    boolean contains(MyObject value);
    MyIteratorFactory getIteratorFactory();
}
