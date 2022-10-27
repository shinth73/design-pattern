package pattern03.abstract_factory.e1;

public class MyListIterator implements MyIterator {
    MyList myList;
    MyList.Node current;

    public MyListIterator(MyList myList) {
        this.myList = myList;
        this.current = this.myList.dummy.next;
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