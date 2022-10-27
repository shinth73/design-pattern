package pattern03.decorator.i1;

class MyArrayReverseIterator implements MyIterator {
    private final MyArray myArray;
    private int current;

    public MyArrayReverseIterator(MyArray myArray) {
        this.myArray = myArray;
        current = this.myArray.getCount() - 1;
    }

    @Override
    public MyObject getNext() {
        return this.myArray.get(current--);
    }

    @Override
    public boolean isEnd() {
        return current < 0;
    }
}