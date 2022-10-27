package pattern01.iterator.e3;

public class MyList {
    private static class Node {
        private int data;
        private Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node dummy;

    public MyList() {
        dummy = new Node(Integer.MIN_VALUE);
        dummy.prev = dummy.next = dummy;
    }

    public void addHead(int value) {
        Node node = new Node(value);
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }

    public void addTail(int value) {
        Node node = new Node(value);
        node.next = dummy;
        node.prev = dummy.prev;
        dummy.prev.next = node;
        dummy.prev = node;
    }

    public static class Position {
        private Node current;
    }

    public Position getFirstPosition() {
        Position pos = new Position();
        pos.current = dummy.next;
        return pos;
    }

    public int getNext(Position pos) {
        int r = pos.current.data;
        pos.current = pos.current.next;
        return r;
    }

    public boolean isEnd(Position pos) {
        return pos.current == dummy;
    }
}
