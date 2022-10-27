package pattern03.abstract_factory.e1;

import java.util.function.Predicate;

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

    @Override
    public MyIterator getConditionalIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(new MyArrayIterator(myArray), predicate);
    }

    @Override
    public MyIterator getConditionalReverseIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(new MyArrayReverseIterator(myArray), predicate);
    }

}
