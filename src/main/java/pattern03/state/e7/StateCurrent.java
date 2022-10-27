package pattern03.state.e7;

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
        return getNextImpl();
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public void remove() {
    	removeImpl(wrapper.stateNoCurrent);
    }
}
