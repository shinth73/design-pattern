package pattern03.strategy.e1;

import java.util.Random;

public class Example1 {

    static Random random = new Random();

    static void doSomething() {
        MyList list = new MyArrayList();
        for (int k = 0; k < 10; ++k) {

            // list 목록을 수정한다
            // 구체적인 수정 작업 내용은 중요하지 않다.
            for (int i = 0; i < 100; ++i) {
                MyInt value = new MyInt(random.nextInt(100));
                if (i % 2 == 0)
                    list.insertAt(0, value);
                else {
                    int index = list.findIndex(value);
                    if (index >= 0) list.removeAt(index);
                }
            }

            // list 목록을 조회한다
            // 구체적인 조회 작업 내용은 중요하지 않다.
            int count = 0;
            for (int i = 0; i < 100; ++i) {
                MyInt value = new MyInt(i);
                if (list.findIndex(value) >= 0)
                    ++count;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        doSomething();
    }

}