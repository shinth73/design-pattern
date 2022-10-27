package pattern03.abstract_factory.e1;

class MyArrayIterator implements MyIterator {
    MyArray myArray;
    int current;

    public MyArrayIterator(MyArray myArray) {
        this.myArray = myArray;
        current = 0;
    }

    @Override
    public MyObject getNext() {
        return this.myArray.get(current++);
    }

    @Override
    public boolean isEnd() {
        return current >= this.myArray.getCount();
    }
}