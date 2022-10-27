package pattern01.prototype.e2;

public interface MyCollection extends Cloneable {
    void add(int value);
    MyIterator getIterator();
    void addAll(MyCollection col);
    MyCollection clone() throws CloneNotSupportedException;

}
