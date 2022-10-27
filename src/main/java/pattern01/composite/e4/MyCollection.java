package pattern01.composite.e4;

public interface MyCollection extends MyObject {
    void add(MyObject value);
    void addAll(MyCollection col);
    boolean contains(MyObject value);
    MyIterator getIterator();
    MyCollection clone() throws CloneNotSupportedException;
}
