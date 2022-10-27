package pattern03.state.e7;

public class MyArrayIterator implements MyIterator {

    MyArray myArray;
    int current;
    MyIteratorState state;

    StateCurrent stateCurrent = new StateCurrent(this);
    StateCurrentEol stateCurrentEol = new StateCurrentEol(this);
    StateNoCurrent stateNoCurrent = new StateNoCurrent(this);
    StateNoCurrentEol stateNoCurrentEol = new StateNoCurrentEol(this);

    public MyArrayIterator(MyArray myArray) {
        this.myArray = myArray;
        this.current = 0;
        this.state = myArray.getCount() > 0 ? stateNoCurrent : stateNoCurrentEol;
    }

    @Override
    public int getNext() {
        return state.getNext();
    }

    @Override
    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public void remove() {
        state.remove();
    }
}
