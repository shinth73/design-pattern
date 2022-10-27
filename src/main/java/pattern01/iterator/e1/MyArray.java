package pattern01.iterator.e1;

import java.util.Arrays;

public class MyArray {
    private int[] data;
    private int count;

    public MyArray() {
        this(8); // 줄13의 생성자를 호출한다
    }

    public MyArray(int size) {
        data = new int[size];
        count = 0;
    }

    // data 배열의 크기는 두 배 확장한다
    private void expand() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    // 배열의 끝에 value를 추가한다.
    public void add(int value) {
        if (count == data.length) expand(); // 배열이 꽉 찼으면 두 배 확장한다
        data[count++] = value;
    }

    public int get(int index) {
        return data[index];
    }

    public int getCount() {
        return count;
    }
}