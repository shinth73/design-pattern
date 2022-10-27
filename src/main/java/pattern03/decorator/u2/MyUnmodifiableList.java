package pattern03.decorator.u2;

public class MyUnmodifiableList implements MyList {
    MyList list;

    MyUnmodifiableList(MyList list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.getCount();
    }

    @Override
    public MyObject getAt(int index) {
        return list.getAt(index);
    }

    @Override
    public void setAt(int index, MyObject data) {
    }

    @Override
    public void insertAt(int index, MyObject data) {
    }

    @Override
    public void removeAt(int index) {
    }

    @Override
    public int findIndex(MyObject data) {
        return list.findIndex(data);
    }
}