package pattern03.decorator.i2;

public class MyListReverseIterator implements MyIterator {
    private MyList myList;
    private MyList.Node current;

    public MyListReverseIterator(MyList myList) {
        this.myList = myList;
        this.current = myList.dummy.prev;
    }

    @Override
    public MyObject getNext() {
        MyObject r = current.data;
        current = current.prev;
        return r;
    }

    @Override
    public boolean isEnd() {
        return current == myList.dummy;
    }

}