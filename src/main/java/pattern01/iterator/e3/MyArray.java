package pattern01.iterator.e3;

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

    public static class Position {
        private int current;
    }

    public Position getFirstPosition() {
        Position pos = new Position();
        pos.current = 0;
        return pos;
    }

    public int getNext(Position pos) {
        return data[pos.current++];
    }

    public boolean isEnd(Position pos) {
        return pos.current >= count;
    }
}
