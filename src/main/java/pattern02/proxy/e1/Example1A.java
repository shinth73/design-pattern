package pattern02.proxy.e1;

public class Example1A {

    static void work(MyList list) {
        for (int i=0; i < 1000; ++i) {
            list.insertAt(0, new MyInt(999));
            list.removeAt(0);
        }
    }

    static void add(MyList list, int count) {
        for (int i=0; i < count; ++i)
            list.add(new MyInt(i));
    }

    static void print(MyList list) {
        System.out.printf("Count: %d\n", list.getCount());
        for (int i=0; i < list.getCount(); ++i)
            System.out.printf("%s ", list.getAt(i));
        System.out.println();
    }

    static void doSomething(MyList list) {
        add(list, 100);
        for (int i=0; i < 100; ++i)
            work(list);
        print(list);
    }

    public static void main(String[] args) {
        doSomething(new MyArrayList());
        doSomething(new MyLinkedList());
    }

}