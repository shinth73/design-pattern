package pattern03.template_method.e2;

//////부품

abstract class MyObject {
    public abstract int compare(MyObject obj);
    public abstract void print();
}

class MyString extends MyObject {
    String _s;

    public MyString(String s) {
        _s = s;
    }

    @Override
    public void print() {
        System.out.printf("%s ", _s);
    }

    @Override
    public int compare(MyObject obj) {
        if (obj instanceof MyString == false)
            return -1;
        return _s.compareTo(((MyString) obj)._s);
    }
}

class MyInteger extends MyObject {
    int _i;

    public MyInteger(int i) {
        _i = i;
    }

    @Override
    public void print() {
        System.out.printf("%d ", _i);
    }

    @Override
    public int compare(MyObject obj) {
        if (obj instanceof MyInteger == false)
            return -1;
        return _i - ((MyInteger) obj)._i;
    }
}

interface Action {
    void run(MyObject object);
}

class MyArray {
    private MyObject[] data;
    private int count;

    public MyArray(int size) {
        data = new MyObject[size];
        count = 0;
    }

    public void add(MyObject value) {
        data[count++] = value;
    }

    public MyObject get(int index) {
        return data[index];
    }

    public int getCount() {
        return count;
    }

    public void doForEach(Action action) {
        for (int i = 0; i < count; ++i)
            action.run(data[i]);
    }

    void quicksort(int lo, int hi) {
        int i = lo, j = hi;
        MyObject h;
        MyObject x = data[(lo + hi) / 2];

        do {
            while (data[i].compare(x) < 0)
                i++;
            while (data[j].compare(x) > 0)
                j--;
            if (i <= j) {
                h = data[i];
                data[i] = data[j];
                data[j] = h;
                i++;
                j--;
            }
        } while (i <= j);

        if (lo < j)
            quicksort(lo, j);
        if (i < hi)
            quicksort(i, hi);
    }

    public void sort() {
        quicksort(0, count - 1);
    }
}

//////클라이언트

class PrintAction implements Action {
    @Override
    public void run(MyObject object) {
        object.print();
    }
}

public class Example2 {

    public static void main(String[] args) {
        MyArray a1 = new MyArray(100);
        MyArray a2 = new MyArray(100);
        PrintAction print = new PrintAction();

        for (int i = 0; i < 20; ++i) {
            int n = (int) (Math.random() * 100);
            String s = String.format("[%d]", n);
            a1.add(new MyInteger(n));
            a2.add(new MyString(s));
        }

        a1.doForEach(print);
        System.out.println("");
        a2.doForEach(print);
        System.out.println("");

        a1.sort();
        a2.sort();

        a1.doForEach(print);
        System.out.println("");
        a2.doForEach(print);
        System.out.println("");
    }
}
