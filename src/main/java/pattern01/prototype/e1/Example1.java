package pattern01.prototype.e1;

public class Example1 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%d ", it.getNext());
        System.out.println();
    }

    static void doSomething(MyCollection col, int count) throws CloneNotSupportedException {
        for (int i = 0; i < count / 2; ++i)
            col.add(i);

        MyCollection col2 = col.clone();

        for (int i = count / 2; i < count; ++i)
            col2.add(i);

        print(col.getIterator());
        print(col2.getIterator());

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        doSomething(new MyArray(), 10);
        doSomething(new MyList(), 10);
    }
}
