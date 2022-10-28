package pattern03.abstract_factory.e2;

import java.util.function.Predicate;

public interface MyIteratorFactory {
    MyIterator getIterator();
    MyIterator getReverseIterator();

    default MyIterator getConditionalIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(getIterator(), predicate);
    }

    default MyIterator getConditionalReverseIterator(Predicate<MyObject> predicate) {
        return new MyConditionalIterator(getReverseIterator(), predicate);
    }
}
