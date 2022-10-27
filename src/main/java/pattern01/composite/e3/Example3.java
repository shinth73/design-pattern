package pattern01.composite.e3;

public class Example3 {

    static void addData(MyCollection col, int count) {
        for (int i = 0; i < count; ++i)
            col.add( i % 2 == 0 ? new MyInt(i) : new MyStr(i) );
    }

    static MyArray createCompositeArray() {
        MyArray a1 = new MyArray(), a2 = new MyArray(), a3 = new MyArray();
        addData(a1, 3);
        addData(a2, 3);
        addData(a3, 3);
        a2.add(a1);
        a3.add(a2);
        return a3;
    }

    static MyList createCompositeList() {
        MyList a1 = new MyList(), a2 = new MyList(), a3 = new MyList();
        addData(a1, 3);
        addData(a2, 3);
        addData(a3, 3);
        a2.add(a1);
        a3.add(a2);
        return a3;
    }

    static MyHashSet createCompositeHashSet() {
        MyHashSet a1 = new MyHashSet(), a2 = new MyHashSet(), a3 = new MyHashSet();
        addData(a1, 3);
        addData(a2, 3);
        addData(a3, 3);
        a2.add(a1);
        a3.add(a2);
        return a3;
    }

    static void testArray() {
        MyArray a1 = createCompositeArray();
        MyArray a2 = createCompositeArray();

        System.out.println(a1.equals(a2));
        System.out.println(a1);
    }


    static void testList() {
        MyList b1 = createCompositeList();
        MyList b2 = createCompositeList();

        System.out.println(b1.equals(b2));
        System.out.println(b1);
    }

    static void testHashset() {
        MyHashSet a1 = createCompositeHashSet();
        MyHashSet a2 = createCompositeHashSet();

        System.out.println(a1.equals(a2));
        System.out.println(a1);
    }

    public static void main(String[] args) {
        testArray();
        testList();
        testHashset();
    }

}
