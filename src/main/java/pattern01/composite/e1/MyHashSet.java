package pattern01.composite.e1;

import java.util.Arrays;

public class MyHashSet extends MyAbstractCollection {

    // 빈 칸을 표시하는 상수로 사용. 따라서 이 값을 사용할 수 없다
    static final int EMPTY = Integer.MIN_VALUE;

    static final double A = 0.3758;
    int[] a;
    int count, threshold;

    public MyHashSet() {
        this(32);
    }

    public MyHashSet(int size) {
        this.a = new int[size];
        this.count = 0;
        this.threshold = (int) (this.a.length * 0.7);
        Arrays.fill(this.a, EMPTY);
    }

    private void expand() {
        int newSize = a.length * 2;
        MyHashSet newHashTable = new MyHashSet(newSize);
        for (int i = 0; i < a.length; ++i)
            if (a[i] != EMPTY) newHashTable.add(a[i]);
        this.a = newHashTable.a;
        this.threshold = newHashTable.threshold;
    }

    private int getStartIndex(int value) { // 최초 저장할 위치 계산
        double fractionalPart = (value * A) % 1;
        return (int) (fractionalPart * this.a.length);
    }

    private static int getStepDistance(int value) { // 충돌 발생한 경우 건너뛸 간격 계산
        final int[] STEPS = {3, 5, 7, 11, 13, 17, 19}; // 소수 크기 간격
        return STEPS[Math.abs(value) % STEPS.length];
    }

    @Override
    public void add(int value) {
        int startIndex = getStartIndex(value);
        int step = getStepDistance(value);
        int collisionCount = 0;
        do {
            int index = (startIndex + collisionCount * step) % a.length;
            if (a[index] == EMPTY) {
                a[index] = value;
                this.count++;
                if (this.count >= this.threshold)
                    expand();
                return;
            } else if (a[index] == value)
                return;
            ++collisionCount;
        } while (collisionCount < a.length);
    }

    @Override
    public boolean contains(int value) {
        int startIndex = getStartIndex(value);
        int step = getStepDistance(value);
        int collisionCount = 0;
        do {
            int index = (startIndex + collisionCount * step) % a.length;
            if (a[index] == EMPTY)
                return false;
            else if (a[index] == value)
                return true;
            ++collisionCount;
        } while (collisionCount < a.length);
        return false;
    }

    private class MyHashsetIterator implements MyIterator {
        private int current;

        public MyHashsetIterator() {
            current = -1;
            next();
        }

        private void next() {
            ++current;
            while (current < a.length && a[current] == EMPTY)
                ++current;
        }

        @Override
        public int getNext() {
            int r = a[current];
            next();
            return r;
        }

        @Override
        public boolean isEnd() {
            return current >= a.length;
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyHashsetIterator();
    }
}
