package pattern03.abstract_factory.e2;

public class MyArrayIteratorFactory implements MyIteratorFactory {
    MyArray myArray;

    public MyArrayIteratorFactory(MyArray myArray) {
        this.myArray = myArray;
    }

    @Override
    public MyIterator getIterator() {
        return new MyArrayIterator(myArray);
    }

    @Override
    public MyIterator getReverseIterator() {
        return new MyArrayReverseIterator(myArray);
    }

}
