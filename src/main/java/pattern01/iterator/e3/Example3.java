package pattern01.iterator.e3;

public class Example3 {

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        MyArray.Position pos = a.getFirstPosition();
        while (!a.isEnd(pos))
            System.out.printf("%d ", a.getNext(pos));
        System.out.println();
    }

    static void doSomething2(int count) {
        MyList list = new MyList();
        for (int i = 0; i < count; ++i)
            list.addTail(i);

        MyList.Position pos = list.getFirstPosition();
        while (!list.isEnd(pos))
            System.out.printf("%d ", list.getNext(pos));
        System.out.println();
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
