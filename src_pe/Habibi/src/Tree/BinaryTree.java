package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    Node root;
    
    public static void preOrder(Node root){
        if(root == null){ //base case
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void iterativePreOrder(Node root){
        if(root == null){ // tree empty
            return;
        }
        Stack<Node> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            } 
        }
    }
    
    public static void inOrder(Node root){
        if(root == null){ //base case
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }
        
    
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        
//        Node first = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//        Node forth = new Node(4);
//        Node fifth = new Node(5);
//        Node sixth = new Node(6);
//        Node seventh = new Node(7);

//        myTree.root = first;
//        myTree.root.left = second;
//        myTree.root.right = third;
//        second.left = forth;
//        second.right = fifth;
//        third.right = sixth;
//        sixth.right = seventh;
        
        levelOrder(myTree.root);
    }
}
