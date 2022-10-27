package pattern03.state.e7;

import java.util.NoSuchElementException;

public class StateNoCurrent extends MyIteratorState {

    public StateNoCurrent(MyArrayIterator myArrayIterator) {
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
        throw new NoSuchElementException();
    }
}
