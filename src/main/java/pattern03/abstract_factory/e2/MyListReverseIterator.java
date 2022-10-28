package pattern03.abstract_factory.e2;

public class MyListReverseIterator implements MyIterator {
    MyList myList;
    MyList.Node current;

    public MyListReverseIterator(MyList myList) {
        this.myList = myList;
        this.current = this.myList.dummy.prev;
    }

    @Override
    public MyObject getNext() {
        MyObject r = current.data;
        current = current.prev;
        return r;
    }

    @Override
    public boolean isEnd() {
        return current == this.myList.dummy;
    }
}