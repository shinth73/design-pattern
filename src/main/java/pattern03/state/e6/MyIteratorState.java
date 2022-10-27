package pattern03.state.e6;


public abstract class MyIteratorState {

    MyArrayIterator wrapper;

    public MyIteratorState(MyArrayIterator myArrayIterator) {
        this.wrapper = myArrayIterator;
    }

    abstract int getNext();
    abstract boolean isEnd();
    abstract void remove();
}
