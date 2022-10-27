package pattern01.polymorphism.e1;

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

    public void addAll(MyArray array) {
        for (int i = 0; i < array.getCount(); ++i)
            add(array.get(i));
    }

    public void addAll(MyList list) {
        MyList.Node node = list.getHeadNode();
        while (node != null) {
            add(node.getData());
            node = list.getNextNode(node);
        }
    }
}