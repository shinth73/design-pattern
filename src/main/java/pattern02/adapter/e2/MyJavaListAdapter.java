package pattern02.adapter.e2;

import java.util.List;

public class MyJavaListAdapter implements MyList {

    private List<MyObject> list;

    public MyJavaListAdapter(List<MyObject> list) {
        this.list = list;
    }

    @Override
    public MyObject getAt(int index) {
        return list.get(index);
    }

    @Override
    public void setAt(int index, MyObject value) {
        list.set(index, value);
    }

    @Override
    public void insertAt(int index, MyObject value) {
        list.add(index, value);
    }

    @Override
    public void removeAt(int index) {
        list.remove(index);
    }

    @Override
    public int findIndex(MyObject value) {
        return list.indexOf(value);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}