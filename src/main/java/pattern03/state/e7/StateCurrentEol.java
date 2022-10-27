package pattern03.state.e7;

import java.util.NoSuchElementException;

public class StateCurrentEol extends MyIteratorState {

    public StateCurrentEol(MyArrayIterator myArrayIterator) {
        super(myArrayIterator);
    }

    @Override
    public int getNext() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEnd() {
        return true;
    }

    @Override
    public void remove() {
    	removeImpl(wrapper.stateNoCurrentEol);
    }
}
