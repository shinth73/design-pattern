package pattern03.state.e6;

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
        wrapper.state = wrapper.stateNoCurrentEol;
        --wrapper.current;
        --wrapper.myArray.count;
        for (int i = wrapper.current; i < wrapper.myArray.count; ++i)
            wrapper.myArray.data[i] = wrapper.myArray.data[i + 1];
    }
}
