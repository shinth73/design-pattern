package pattern01.polymorphism.e1;

public class Example1 {

    static void print(MyArray a) {
        for (int i = 0; i < a.getCount(); ++i)
            System.out.printf("%d ", a.get(i));
        System.out.println();
    }

    static void print(MyList list) {
        MyList.Node node = list.getHeadNode();
        while (node != null) {
            System.out.printf("%d ", node.getData());
            node = list.getNextNode(node);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray a1 = new MyArray();
        for (int i = 0; i < 5; ++i)
            a1.add(i);

        MyList b1 = new MyList();
        b1.addAll(a1);

        MyArray a2 = new MyArray();
        a2.addAll(a1);
        a2.addAll(b1);
        print(a2);

        MyList b2 = new MyList();
        b2.addAll(a1);
        b2.addAll(b1);
        print(b2);
    }
}
