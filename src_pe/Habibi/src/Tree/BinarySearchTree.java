package Tree;

class BinarySearchTree {
    Node root;
    
    class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public Node search(int value) {
        return search(root, value);
    }
    
    public Node search(Node root, int value) {
        if (root == null || root.data == value) {
            return root;
        }
        
        if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }
    
    public boolean isValid(long min, long max) {
        return isValid(root, min, max);
    }
    
    public boolean isValid(Node root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        boolean left = isValid(root.left, min, root.data);
        if (left) {
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(8);
        
        System.out.print("Inorder traversal of BST 1: ");
        bst.inOrder();
        
        System.out.println("Searching for 7: " + (bst.search(7) != null ? "Value Found!" : "Value not found!"));
        System.out.println("Is BST 1 valid? " + (bst.isValid(Long.MIN_VALUE, Long.MAX_VALUE) ? "Yes" : "No"));
        
        BinarySearchTree bst2 = new BinarySearchTree();
        
//        Node first = new Node(5);
//        Node second = new Node(3);
//        Node third = new Node(6);
//        Node fourth = new Node(2);
//        Node fifth = new Node(4);
//        Node sixth = new Node(8);
        
//        bst2.root = first;
//        first.left = second;
//        first.right = third;
//        second.left = fourth;
//        second.right = fifth;  // Now 4 instead of 7
//        third.right = sixth;
        
        System.out.print("Inorder traversal of BST 2: ");
        bst2.inOrder();
        
        System.out.println("Is BST 2 valid? " + (bst2.isValid(Long.MIN_VALUE, Long.MAX_VALUE) ? "Yes" : "No"));
    }
}