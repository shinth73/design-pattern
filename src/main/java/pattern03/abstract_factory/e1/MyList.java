package pattern03.abstract_factory.e1;

public class MyList implements MyCollection {
    static class Node {
        MyObject data;
        Node prev, next;

        Node(MyObject data) {
            this.data = data;
        }
    }

    Node dummy;

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

    @Override
    public MyIteratorFactory getIteratorFactory() {
        return new MyListIteratorFactory(this);
    }
}