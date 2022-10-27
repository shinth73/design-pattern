package pattern01.composite.e1;

public class Example1 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%d ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add(i);
        System.out.printf("%s %s ", col.contains(3), !col.contains(count));
        print(col.getIterator());
    }

    public static void main(String[] args) {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
        doSomething(new MyHashSet(), 10);
    }
}
