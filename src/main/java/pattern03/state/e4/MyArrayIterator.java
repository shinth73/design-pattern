package pattern03.state.e4;

class MyArrayIterator implements MyIterator {
    MyArray myArray;
    int current;

    public MyArrayIterator(MyArray myArray) {
        this.myArray = myArray;
        this.current = 0;
    }

    @Override
    public int getNext() {
        return myArray.data[current++];
    }

    @Override
    public boolean isEnd() {
        return current >= myArray.count;
    }

    @Override
    public void remove() {
        --current;
        --myArray.count;
        for (int i = current; i < myArray.count; ++i)
            myArray.data[i] = myArray.data[i + 1];
    }
}