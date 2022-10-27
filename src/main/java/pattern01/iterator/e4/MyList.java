package pattern01.iterator.e4;

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

    public class Position {
        private Node current;

        public Position() {
            current = dummy.next;
        }

        public int getNext() {
            int r = current.data;
            current = current.next;
            return r;
        }

        public boolean isEnd() {
            return current == dummy;
        }
    }

    public Position getFirstPosition() {
        return new Position();
    }
}
