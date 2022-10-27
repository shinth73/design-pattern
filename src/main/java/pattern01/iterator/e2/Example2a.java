package pattern01.iterator.e2;

public class Example2a {

    static void doSomething1(int count) {
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                a.moveFirst();
                while (!a.isEnd())
                    System.out.printf("%d ", a.next());
            }).start();
        }
    }

    public static void main(String[] args) {
        doSomething1(10);
    }
}
