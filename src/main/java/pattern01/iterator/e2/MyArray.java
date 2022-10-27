package pattern01.iterator.e2;

import java.util.Arrays;

public class MyArray {
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

    private int current;

    public void moveFirst() {
        current = 0;
    }

    public int next() {
        return data[current++];
    }

    public boolean isEnd() {
        return current >= count;
    }
}
