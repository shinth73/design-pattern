package pattern01.iterator.e1;

public class MyList {
    public static class Node {
        private int data;
        private Node prev, next;

        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
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

    public Node getHeadNode() {
        return getNextNode(dummy);
    }

    public Node getNextNode(Node node) {
        Node next = node.next;
        return next != dummy ? next : null;
    }
}