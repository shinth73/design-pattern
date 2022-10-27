package pattern02.visitor.e3;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class MyBinaryTree {
    Node root;

    public MyBinaryTree() {
        root = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
}

interface Visitor {
    void visit(int data);
}

public class Example3 {

    static void addData(MyBinaryTree c) {
        int data[] = { 5, 0, 1, 9, 3, 4, 8, 7, 6, 2 };
        for (int i = 0; i < 10; ++i)
            c.add(data[i]);
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        addData(tree);

        //tree.accept(new PrintVisitor());

        //SumVisitor visitor = new SumVisitor();
        //tree.accept(visitor);
        //System.out.printf("\nsum: %d\n", visitor.getResult());
    }
}