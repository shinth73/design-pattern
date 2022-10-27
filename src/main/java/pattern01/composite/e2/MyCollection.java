package pattern01.composite.e2;

public interface MyCollection {
    void add(MyObject value);
    void addAll(MyCollection col);
    boolean contains(MyObject value);
    MyIterator getIterator();
    MyCollection clone() throws CloneNotSupportedException;
}
