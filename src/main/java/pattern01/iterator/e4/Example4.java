package pattern01.iterator.e4;

public class Example4 {

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        MyArray.Position pos = a.getFirstPosition();
        while (!pos.isEnd())
            System.out.printf("%d ", pos.getNext());
        System.out.println();
    }

    static void doSomething2(int count) {
        MyList list = new MyList();
        for (int i = 0; i < count; ++i)
            list.addTail(i);

        MyList.Position pos = list.getFirstPosition();
        while (!pos.isEnd())
            System.out.printf("%d ", pos.getNext());
        System.out.println();
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
