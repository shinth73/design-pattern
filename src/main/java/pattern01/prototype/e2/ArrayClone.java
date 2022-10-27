package pattern01.prototype.e2;

import java.util.Arrays;

public class ArrayClone {

    static class Point implements Cloneable {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public Point clone() throws CloneNotSupportedException {
            return (Point)super.clone();
        }

        @Override
        public String toString() {
            return String.format("Point(%d, %d)", x, y);
        }
    }

    static Point[] shallowCopy1(Point[] a) {
        return a;
    }

    static Point[] shallowCopy2(Point[] a) {
        Point[] b = new Point[a.length];
        for (int i = 0; i < a.length; ++i)
            b[i] = a[i];
        return b;
    }

    static Point[] deepCopy(Point[] a) throws CloneNotSupportedException {
        Point[] b = new Point[a.length];
        for (int i = 0; i < a.length; ++i)
            b[i] = a[i].clone();
        return b;
    }

    public static void main(String[] args) {
        Point[] a1 = new Point[] { new Point(1, 1), new Point(2, 2) };

        Point[] a2 = shallowCopy1(a1);
        Point[] a3 = shallowCopy2(a1);

        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }

}
