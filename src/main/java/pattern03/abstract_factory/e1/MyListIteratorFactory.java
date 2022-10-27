package pattern03.abstract_factory.e1;

import java.util.function.Predicate;

public class MyListIteratorFactory implements MyIteratorFactory {
    MyList myList;

    public MyListIteratorFactory(MyList myList) {
        this.myList = myList;
    }

    @Override
    public MyIterator getIterator() {
        return new MyListIterator(myList);
    }

    @Override
    public MyIterator getReverseIterator() {
        return new MyListReverseIterator(myList);
    }

    @Override
    public MyIterator getConditionalIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(new MyListIterator(myList), predicate);
    }

    @Override
    public MyIterator getConditionalReverseIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(new MyListReverseIterator(myList), predicate);
    }
}
