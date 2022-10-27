package pattern01.composite.e2;

public class Example2 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%s ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i % 2 == 0 ? new MyInt(i) : new MyStr(i));

        System.out.printf("%s %s ", col.contains(new MyInt(2)), !col.contains(new MyStr(2)));
        print(col.getIterator());
    }

    public static void main(String[] args) {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
        doSomething(new MyHashSet(), 10);
    }
}
