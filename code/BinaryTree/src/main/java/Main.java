public class Main {
    public static void main(String[] args) {
        // sample binary tree
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(binaryTree.root, 10);
        binaryTree.insert(binaryTree.root, 5);
        binaryTree.insert(binaryTree.root, 15);
        binaryTree.insert(binaryTree.root, 3);
        binaryTree.insert(binaryTree.root, 7);
        binaryTree.insert(binaryTree.root, 12);

        binaryTree.display(binaryTree.root);  
    }
}