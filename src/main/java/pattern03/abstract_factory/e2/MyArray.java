package pattern03.abstract_factory.e2;

import java.util.Arrays;

public class MyArray implements MyCollection {
    MyObject[] data;
    int count;

    public MyArray() {
        this(8);
    }

    public MyArray(int size) {
        data = new MyObject[size];
        count = 0;
    }

    private void expand() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public void add(MyObject value) {
        if (count == data.length) expand();
        data[count++] = value;
    }

    public MyObject get(int index) {
        return data[index];
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean contains(MyObject value) {
        for (int i = 0; i < count; ++i)
            if (data[i].equals(value)) return true;
        return false;
    }

    @Override
    public MyIteratorFactory getIteratorFactory() {
        return new MyArrayIteratorFactory(this);
    }
}
