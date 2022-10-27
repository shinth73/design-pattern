package pattern01.iterator.e7;

public class MyList implements MyCollection {
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

    @Override
    public void add(int value) {
        addTail(value);
    }

    private class MyListIterator implements MyIterator {
        protected Node current;

        MyListIterator() {
            current = dummy.next;
        }

        @Override
        public int getNext() {
            int r = current.data;
            current = current.next;
            return r;
        }

        @Override
        public boolean isEnd() {
            return current == dummy;
        }
    }

    private class MyListReverseIterator extends MyListIterator {

        MyListReverseIterator() {
            current = dummy.prev;
        }

        @Override
        public int getNext() {
            int r = current.data;
            current = current.prev;
            return r;
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyListIterator();
    }

    @Override
    public MyIterator getReverseIterator() {
        return new MyListReverseIterator();
    }
}
