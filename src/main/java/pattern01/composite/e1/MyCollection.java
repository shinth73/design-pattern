package pattern01.composite.e1;

public interface MyCollection {
    void add(int value);
    void addAll(MyCollection col);
    boolean contains(int value);
    MyIterator getIterator();
    MyCollection clone() throws CloneNotSupportedException;
}
