public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Node root, int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            if (root.value < value) {
                if (root.right == null) {
                    root.right = new Node(value);
                } else {
                    insert(root.right, value);
                }
            } else {
                if (root.left == null) {
                    root.left = new Node(value);
                } else {
                    insert(root.left, value);
                }
            }
        }
    }

    public boolean search(int value, Node root) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        } else if (root.value < value) {
            return search(value, root.right);
        } else {
            return search(value, root.left);
        }
    }

    // display the binary tree
    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.value);
            display(root.right);
        }
    }
}
