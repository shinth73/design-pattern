package pattern01.iterator.e5;

public class Example5 {

    static void print(Position pos) {
        while (!pos.isEnd())
            System.out.printf("%d ", pos.getNext());
        System.out.println();
    }

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        print(a.getFirstPosition());
    }

    static void doSomething2(int count) {
        MyList list = new MyList();
        for (int i = 0; i < count; ++i)
            list.addTail(i);

        print(list.getFirstPosition());
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
