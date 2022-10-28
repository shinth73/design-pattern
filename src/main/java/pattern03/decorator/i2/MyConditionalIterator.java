package pattern03.decorator.i2;

import java.util.function.Predicate;

class MyConditionalIterator implements MyIterator {
    private MyIterator iterator;
    private Predicate<MyObject> predicate;
    private MyObject value;
    private boolean end;

    public MyConditionalIterator(MyIterator iterator, Predicate<MyObject> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        this.value = findNext();
        this.end = false;
    }

    private MyObject findNext() {
        while (!iterator.isEnd()) {
            MyObject value = iterator.getNext();
            if (predicate.test(value)) return value;
        }
        this.end = true;
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
        return end;
    }
}
