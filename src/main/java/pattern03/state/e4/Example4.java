package pattern03.state.e4;

import java.util.function.Predicate;

public class Example4 {

    static void add(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i);
    }

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%d ", it.getNext());
        System.out.println();
    }

    // predicate를 만족하는 항목들을 제거한다
    static void remove(MyIterator it, Predicate<Integer> predicate) {
        while (!it.isEnd())
            if (predicate.test(it.getNext()))
                it.remove();
    }

    static void doSomething1(MyCollection col) {
        add(col, 10);
        print(col.getIterator());
        remove(col.getIterator(), value -> value < 5); // 5 미만 제거
        print(col.getIterator());
        remove(col.getIterator(), value -> value > 5); // 5 초과 제거
        print(col.getIterator());
    }

    static void doSomething2(MyCollection col) {
    	add(col, 10);
    	MyIterator it = col.getIterator();
    	it.remove();
    	print(col.getIterator());
    }

    public static void main(String[] args) {
        doSomething1(new MyArray());
        doSomething2(new MyArray());
    }
}
