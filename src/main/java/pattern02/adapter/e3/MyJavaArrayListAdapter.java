package pattern02.adapter.e3;

import java.util.ArrayList;

public class MyJavaArrayListAdapter extends ArrayList<MyObject> implements MyList {

    @Override
    public MyObject getAt(int index) {
        return super.get(index);
    }

    @Override
    public void setAt(int index, MyObject value) {
        super.set(index, value);
    }

    @Override
    public void insertAt(int index, MyObject value) {
        super.add(index, value);
    }

    @Override
    public void removeAt(int index) {
        super.remove(index);
    }

    @Override
    public int findIndex(MyObject value) {
        return super.indexOf(value);
    }

    @Override
    public int getCount() {
        return super.size();
    }
}