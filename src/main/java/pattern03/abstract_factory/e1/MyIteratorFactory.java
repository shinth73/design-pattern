package pattern03.abstract_factory.e1;

import java.util.function.Predicate;

public interface MyIteratorFactory {
    MyIterator getIterator();
    MyIterator getReverseIterator();
    MyIterator getConditionalIterator(Predicate<MyObject> predicate);
    MyIterator getConditionalReverseIterator(Predicate<MyObject> predicate);
}
