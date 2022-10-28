package pattern03.decorator.i2;

public class Example2 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%s ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i % 2 == 0 ? new MyInt(i) : new MyStr(i));

        print(col.getIterator());
        print(col.getReverseIterator());
        print(new MyConditionalIterator(col.getIterator(), (obj) -> obj instanceof MyInt));
        print(new MyConditionalIterator(col.getReverseIterator(), (obj) -> obj instanceof MyStr));
    }

    public static void main(String[] args) {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
    }
}
