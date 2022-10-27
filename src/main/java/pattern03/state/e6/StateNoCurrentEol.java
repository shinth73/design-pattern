package pattern03.state.e6;

import java.util.NoSuchElementException;

public class StateNoCurrentEol extends MyIteratorState {

    public StateNoCurrentEol(MyArrayIterator myArrayIterator) {
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
        throw new NoSuchElementException();
    }
}
