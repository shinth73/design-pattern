package pattern01.polymorphism.e2;

public class Example2 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%d ", it.getNext());
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray a1 = new MyArray();
        for (int i = 0; i < 5; ++i)
            a1.add(i);

        MyList b1 = new MyList();
        b1.addAll(a1.getIterator());

        MyArray a2 = new MyArray();
        a2.addAll(a1.getIterator());
        a2.addAll(b1.getIterator());
        print(a2.getIterator());

        MyList b2 = new MyList();
        b2.addAll(a1.getIterator());
        b2.addAll(b1.getIterator());
        print(b2.getIterator());
    }
}
