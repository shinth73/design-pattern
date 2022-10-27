package pattern01.polymorphism.e4;

public interface MyCollection {
    void add(int value);
    MyIterator getIterator();
    void addAll(MyCollection col);

}
