package pattern03.strategy.e1;

public class MyStrategyList {

    public static final int LINKEDLIST = 0, ARRAYLIST = 1;

    MyList list = new MyLinkedList();
    int strategy = LINKEDLIST;

    public MyObject getAt(int index) {
        return list.getAt(index);
    }

    public void setAt(int index, MyObject value) {
        list.setAt(index, value);
    }

    public void insertAt(int index, MyObject value) {
        list.insertAt(index, value);
    }

    public void removeAt(int index) {
        list.removeAt(index);
    }

    public int findIndex(MyObject value) {
        return list.findIndex(value);
    }

    public int getCount() {
        return list.getCount();
    }

    public void setStrategy(int strategy) {
        if (this.strategy == strategy) return;
        this.strategy = strategy;
        MyList list2 = (strategy == ARRAYLIST ? new MyArrayList() : new MyLinkedList());
        list2.addAll(list);
        list = list2;
    }
}
