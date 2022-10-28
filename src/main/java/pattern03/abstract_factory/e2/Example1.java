package pattern03.abstract_factory.e2;

public class Example1 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%s ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i % 2 == 0 ? new MyInt(i) : new MyStr(i));

        MyIteratorFactory factory = col.getIteratorFactory();
        print(factory.getIterator());
        print(factory.getReverseIterator());
        print(factory.getConditionalIterator((obj) -> obj instanceof MyInt));
        print(factory.getConditionalReverseIterator((obj) -> obj instanceof MyStr));
    }

    public static void main(String[] args) {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
    }
}
