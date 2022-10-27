package pattern02.adapter.e3;

public class MySynchronizedList implements MyList {
    MyList list;

    MySynchronizedList(MyList list) {
        this.list = list;
    }

    @Override
    public synchronized int getCount() {
        return list.getCount();
    }

    @Override
    public synchronized MyObject getAt(int index) {
        return list.getAt(index);
    }

    @Override
    public synchronized void setAt(int index, MyObject data) {
        list.setAt(index, data);
    }

    @Override
    public synchronized void insertAt(int index, MyObject data) {
        list.insertAt(index, data);
    }

    @Override
    public synchronized void removeAt(int index) {
        list.removeAt(index);
    }

    @Override
    public synchronized int findIndex(MyObject data) {
        return list.findIndex(data);
    }
}