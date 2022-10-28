package pattern03.decorator.i2;

public class MyListIterator implements MyIterator {
    protected MyList myList;
    protected MyList.Node current;

    public MyListIterator(MyList myList) {
        this.myList = myList;
        this.current = myList.dummy.next;
    }

    @Override
    public MyObject getNext() {
        MyObject r = current.data;
        current = current.next;
        return r;
    }

    @Override
    public boolean isEnd() {
        return current == myList.dummy;
    }

}