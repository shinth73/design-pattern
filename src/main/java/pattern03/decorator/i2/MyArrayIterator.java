package pattern03.decorator.i2;

class MyArrayIterator implements MyIterator {
    private final MyArray myArray;
    private int current;

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