package pattern01.iterator.e6;

public class Example6 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%d ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i);

        print(col.getIterator());
    }

    public static void main(String[] args) {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
    }
}
