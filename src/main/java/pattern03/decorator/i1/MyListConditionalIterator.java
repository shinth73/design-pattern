package pattern03.decorator.i1;

import java.util.function.Predicate;

class MyListConditionalIterator implements MyIterator {
    private MyList myList;
    private MyList.Node current;
    private Predicate<MyObject> predicate;
    private MyObject value;

    public MyListConditionalIterator(MyList myList, Predicate<MyObject> predicate) {
        this.myList = myList;
        this.current = myList.dummy.next;
        this.predicate = predicate;
        this.value = findNext();
    }

    private MyObject findNext() {
        while (!(current == myList.dummy)) {
            MyObject value = current.data;
            current = current.next;
            if (predicate.test(value)) return value;
        }
        return null;
    }

    @Override
    public MyObject getNext() {
        MyObject r = value;
        value = findNext();
        return r;
    }

    @Override
    public boolean isEnd() {
        return value == null;
    }
}