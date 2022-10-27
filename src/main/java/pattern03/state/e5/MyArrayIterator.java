package pattern03.state.e5;

import java.util.NoSuchElementException;

public class MyArrayIterator implements MyIterator {

    enum IteratorState {
        NO_CURRENT, CURRENT, NO_CURRENT_EOL, CURRENT_EOL
    }

    MyArray myArray;
    int current;
    IteratorState state;

    public MyArrayIterator(MyArray myArray) {
        this.myArray = myArray;
        this.current = 0;
        this.state = myArray.getCount() > 0 ?
                IteratorState.NO_CURRENT : IteratorState.NO_CURRENT_EOL;
    }

    @Override
    public int getNext() {
        switch (state) {
        case NO_CURRENT:
        case CURRENT:
            if (current < myArray.count - 1)
                state = IteratorState.CURRENT;
            else
                state = IteratorState.CURRENT_EOL;
            break;
        case NO_CURRENT_EOL:
        case CURRENT_EOL:
            throw new NoSuchElementException();
        }
        return myArray.data[current++];
    }

    @Override
    public boolean isEnd() {
        boolean result = false;
        switch (state) {
        case NO_CURRENT:
        case CURRENT:
            result = false;
            break;
        case NO_CURRENT_EOL:
        case CURRENT_EOL:
            result = true;
            break;
        }
        return result;
    }

    @Override
    public void remove() {
        switch (state) {
        case NO_CURRENT:
        case NO_CURRENT_EOL:
            throw new NoSuchElementException();
        case CURRENT:
            state = IteratorState.NO_CURRENT;
            break;
        case CURRENT_EOL:
            state = IteratorState.NO_CURRENT_EOL;
            break;
        }
        --current;
        --myArray.count;
        for (int i = current; i < myArray.count; ++i)
            myArray.data[i] = myArray.data[i + 1];
    }
}
