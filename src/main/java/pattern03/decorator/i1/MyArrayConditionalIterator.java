package pattern03.decorator.i1;

import java.util.function.Predicate;

class MyArrayConditionalIterator implements MyIterator {
    private MyArray myArray;
    private int current;
    private Predicate<MyObject> predicate;
    private MyObject value;

    public MyArrayConditionalIterator(MyArray myArray, Predicate<MyObject> predicate) {
        this.myArray = myArray;
        this.current = 0;
        this.predicate = predicate;
        this.value = findNext();
    }

    private MyObject findNext() {
        while (!(current >= this.myArray.getCount())) {
            MyObject value = this.myArray.get(current++);
            if (predicate.test(value)) return value;
        }
        return null;
    }

    @Override
    public MyObject getNext() {
        MyObject r = value;
        value = findNext();
        return r;
    }

    @Override
    public boolean isEnd() {
        return value == null;
    }
}