package pattern01.iterator.e2;

public class Example2 {

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        a.moveFirst();
        while (!a.isEnd())
            System.out.printf("%d ", a.next());
        System.out.println();
    }

    static void doSomething2(int count) {
        MyList list = new MyList();
        for (int i = 0; i < count; ++i)
            list.addTail(i);

        list.moveFirst();
        while (!list.isEnd())
            System.out.printf("%d ", list.next());
        System.out.println();
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
