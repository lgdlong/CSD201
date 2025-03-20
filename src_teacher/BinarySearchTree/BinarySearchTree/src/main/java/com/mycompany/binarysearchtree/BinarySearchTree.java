/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarysearchtree;

/**
 *
 * @author Legion 5 Pro
 */
public class BinarySearchTree {
    private TreeNode root;
    
    private static class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public void insert(int data){
        root = insert(root, data);
    }
    
    private TreeNode insert(TreeNode root, int data){
        if (root == null){ // base case
            root = new TreeNode(data);
            return root;
        }
        
        if (data < root.data){
            root.left = insert(root.left, data);
            
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public void inOrder(){
        inOrder(root);
    }
    
    private void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public TreeNode search(int value){
        return search(root, value);
    }
    
    public TreeNode search(TreeNode root, int value){
        if (root == null || root.data == value){
            return root;
        }
        
        if (value < root.data){
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }
    
    public boolean isValid(long min, long max){
        return isValid(root, min, max);
    }
    
    public boolean isValid(TreeNode root, long min, long max){
        if (root == null){ //base case
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValid(root.left, min, root.data);
        if (left){
            boolean right = isValid(root.right, root.data, max);
            return right; // boolean
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
        
        bst.inOrder();
        
        BinarySearchTree bst2 = new BinarySearchTree();
        
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(6);
        TreeNode forth = new TreeNode(2);
        TreeNode fifth = new TreeNode(7);
        TreeNode sixth = new TreeNode(8);
        
        bst2.root = first;
        first.left = second;
        first.right = third;
        second.left = forth;
        second.right = fifth;
        third.right = sixth;
        
        System.out.println("");
        if(bst.search(7) != null){
            System.out.println("Value Found!");
        } else {
            System.out.println("Value not found!");
        }
        
        if(bst2.isValid(Long.MIN_VALUE, Long.MAX_VALUE)){
            System.out.println("This tree is Binary Search Tree");
        } else {
            System.out.println("This tree is not Binary Search Tree");
        }
    }
}
