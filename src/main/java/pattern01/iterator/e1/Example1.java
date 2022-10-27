package pattern01.iterator.e1;

public class Example1 {

    static void doSomething1(int count) {
        // MyArray 객체에 0 부터 9 까지 저장한다
        MyArray a = new MyArray();
        for (int i = 0; i < count; ++i)
            a.add(i);

        // MyArray 탐색
        for (int i = 0; i < a.getCount(); ++i)
            System.out.printf("%d ", a.get(i));
        System.out.println();
    }

    static void doSomething2(int count) {
        // MyList 객체에 0 부터 9 까지 저장한다
        MyList list = new MyList();
        for (int i = 0; i < count; ++i)
            list.addTail(i);

        // MyList 탐색
        MyList.Node node = list.getHeadNode();
        while (node != null) {
            System.out.printf("%d ", node.getData());
            node = list.getNextNode(node);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
