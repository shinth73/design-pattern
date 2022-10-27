package pattern01.iterator.e7;

import java.util.Arrays;

public class MyArray implements MyCollection {
    private int[] data;
    private int count;

    public MyArray() {
        this(8);
    }

    public MyArray(int size) {
        data = new int[size];
        count = 0;
    }

    private void expand() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public void add(int value) {
        if (count == data.length) expand();
        data[count++] = value;
    }

    public int get(int index) {
        return data[index];
    }

    public int getCount() {
        return count;
    }

    private class MyArrayIterator implements MyIterator {
        private int current;

        public MyArrayIterator() {
            current = 0;
        }

        @Override
        public int getNext() {
            return data[current++];
        }

        @Override
        public boolean isEnd() {
            return current >= count;
        }
    }

    private class MyArrayReverseIterator implements MyIterator {
        private int current;

        public MyArrayReverseIterator() {
            current = count - 1;
        }

        @Override
        public int getNext() {
            return data[current--];
        }

        @Override
        public boolean isEnd() {
            return current < 0;
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyArrayIterator();
    }

    @Override
    public MyIterator getReverseIterator() {
        return new MyArrayReverseIterator();
    }
}
