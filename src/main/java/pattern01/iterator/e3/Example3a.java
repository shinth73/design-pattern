package pattern01.iterator.e3;

public class Example3a {

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                MyArray.Position pos = a.getFirstPosition();
                while (!a.isEnd(pos))
                    System.out.printf("%d ", a.getNext(pos));
            }).start();
        }
    }

    public static void main(String[] args) {
        doSomething1(10);
    }
}
