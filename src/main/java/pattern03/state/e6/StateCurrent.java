package pattern03.state.e6;

public class StateCurrent extends MyIteratorState {

    public StateCurrent(MyArrayIterator myArrayIterator) {
        super(myArrayIterator);
    }

    @Override
    public int getNext() {
        if (wrapper.current < wrapper.myArray.count - 1)
            wrapper.state = wrapper.stateCurrent;
        else
            wrapper.state = wrapper.stateCurrentEol;
        return wrapper.myArray.data[wrapper.current++];
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public void remove() {
        wrapper.state = wrapper.stateNoCurrent;
        --wrapper.current;
        --wrapper.myArray.count;
        for (int i = wrapper.current; i < wrapper.myArray.count; ++i)
            wrapper.myArray.data[i] = wrapper.myArray.data[i + 1];
    }
}
