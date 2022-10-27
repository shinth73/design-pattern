package pattern03.decorator.i1;

public class Example1 {

    static void print(MyIterator it) {
        while (!it.isEnd())
            System.out.printf("%s ", it.getNext());
        System.out.println();
    }

    static void doSomething1(int count) {
        MyArray myArray = new MyArray();
        for (int i = 0; i < count; ++i)
            myArray.add(i % 2 == 0 ? new MyInt(i) : new MyStr(i));

        print(new MyArrayIterator(myArray));        // 가
        print(new MyArrayReverseIterator(myArray)); // 나
        print(new MyArrayConditionalIterator(myArray, (obj) -> obj instanceof MyInt));        // 다
        print(new MyArrayConditionalReverseIterator(myArray, (obj) -> obj instanceof MyStr)); // 라
    }

    static void doSomething2(int count) {
        MyList myList = new MyList();
        for (int i = 0; i < count; ++i)
            myList.add(i % 2 == 0 ? new MyInt(i) : new MyStr(i));

        print(new MyListIterator(myList));         // 가
        print(new MyListReverseIterator(myList));  // 나
        print(new MyListConditionalIterator(myList, (obj) -> obj instanceof MyInt));        // 다
        print(new MyListConditionalReverseIterator(myList, (obj) -> obj instanceof MyStr)); // 라
    }

    public static void main(String[] args) {
        doSomething1(10);
        doSomething2(10);
    }
}
