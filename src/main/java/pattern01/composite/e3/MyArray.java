package pattern01.composite.e3;

import java.util.Arrays;

public class MyArray extends MyAbstractCollection {
    private MyObject[] data;
    private int count;

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

    private class MyArrayIterator implements MyIterator {
        private int current;

        public MyArrayIterator() {
            current = 0;
        }

        @Override
        public MyObject getNext() {
            return data[current++];
        }

        @Override
        public boolean isEnd() {
            return current >= count;
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyArrayIterator();
    }

    @Override
    public boolean equals(MyObject obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyArray myArray = (MyArray)obj;
        if (count != myArray.count) return false;
        for (int i = 0; i < count; ++i) {
            if (data[i] == null && myArray.get(i) != null) return false;
            if (data[i] != null && data[i].equals(myArray.get(i)) == false) return false;
        }
        return true;
    }

    @Override
    public int hashValue() {
        int result = 0;
        for (int i = 0; i < count; ++i)
            if (data[i] != null)
                result = (31 * result + data[i].hashValue()) & 0xFFFFFF;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyArray( ");
        for (int i = 0; i < count; ++i)
            builder.append(data[i]).append(' ');
        builder.append(')');
        return builder.toString();
    }
}
