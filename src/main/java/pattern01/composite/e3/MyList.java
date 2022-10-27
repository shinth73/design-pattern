package pattern01.composite.e3;

public class MyList extends MyAbstractCollection {
    private static class Node {
        private MyObject data;
        private Node prev, next;

        Node(MyObject data) {
            this.data = data;
        }
    }

    private Node dummy;

    public MyList() {
        dummy = new Node(null);
        dummy.prev = dummy.next = dummy;
    }

    public void addHead(MyObject value) {
        Node node = new Node(value);
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }

    public void addTail(MyObject value) {
        Node node = new Node(value);
        node.next = dummy;
        node.prev = dummy.prev;
        dummy.prev.next = node;
        dummy.prev = node;
    }

    @Override
    public void add(MyObject value) {
        addTail(value);
    }

    @Override
    public boolean contains(MyObject value) {
        Node node = dummy.next;
        while (node != dummy) {
            if (node.data.equals(value)) return true;
            node = node.next;
        }
        return false;
    }

    private class MyListIterator implements MyIterator {
        private Node current;

        MyListIterator() {
            current = dummy.next;
        }

        @Override
        public MyObject getNext() {
            MyObject r = current.data;
            current = current.next;
            return r;
        }

        @Override
        public boolean isEnd() {
            return current == dummy;
        }
    }

    @Override
    public MyIterator getIterator() {
        return new MyListIterator();
    }

    @Override
    public boolean equals(MyObject obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyList myList = (MyList)obj;
        Node node1 = dummy.next, node2 = myList.dummy.next;
        while (node1 != dummy && node2 != dummy) {
            if (node1.data == null && node2.data != null) return false;
            if (node1.data != null && node1.data.equals(node2.data) == false) return false;
             node1 = node1.next;
             node2 = node2.next;
        }
        if (node1 != dummy || node2 != myList.dummy) return false;
        return true;
    }

    @Override
    public int hashValue() {
        int result = 0;
        Node node = dummy.next;
        while (node != dummy) {
            if (node.data != null)
                result = (31 * result + node.data.hashValue()) & 0xFFFFFF;
            node = node.next;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyList( ");
        Node node = dummy.next;
        while (node != dummy) {
            builder.append(node.data).append(' ');
            node = node.next;
        }
        builder.append(')');
        return builder.toString();
    }
}
