package pattern03.strategy.e1;

interface MyList {

    MyObject getAt(int index);
    void setAt(int index, MyObject value);
    void insertAt(int index, MyObject value);
    void removeAt(int index);
    int findIndex(MyObject value);
    int getCount();

    default void add(MyObject value) {
        insertAt(getCount(), value);
    }

    default void remove(MyObject value) {
        int index = findIndex(value);
        if (index == -1)
            return;
        removeAt(index);
    }

    default void addAll(MyList list) {
        for (int i = 0; i < list.getCount(); ++i)
            add(list.getAt(i));
    }
}