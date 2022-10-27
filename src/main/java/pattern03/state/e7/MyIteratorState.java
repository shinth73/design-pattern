package pattern03.state.e7;

public abstract class MyIteratorState {

    MyArrayIterator wrapper;

    public MyIteratorState(MyArrayIterator myArrayIterator) {
        this.wrapper = myArrayIterator;
    }

    abstract int getNext();
    abstract boolean isEnd();
    abstract void remove();

    int getNextImpl() {
        return wrapper.myArray.data[wrapper.current++];
    }

    void removeImpl(MyIteratorState nextState) {
        wrapper.state = nextState;
        --wrapper.current;
        --wrapper.myArray.count;
        for (int i = wrapper.current; i < wrapper.myArray.count; ++i)
            wrapper.myArray.data[i] = wrapper.myArray.data[i + 1];
    }
}
