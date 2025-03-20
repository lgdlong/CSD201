/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/**
 *
 * @author Legion 5 Pro
 */
public class BinaryTree {
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
    
    private TreeNode root;
    
    public static void preOrder(TreeNode root){
        if(root == null){ //base case
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void iterativePreOrder(TreeNode root){
        if(root == null){ // tree emoty
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            } 
        }
    }
    
    public static void inOrder(TreeNode root){
        if(root == null){ //base case
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
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
        
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode forth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        
        myTree.root = first;
        myTree.root.left = second;
        myTree.root.right = third;
        second.left = forth;
        second.right = fifth;
        third.right = sixth;
        sixth.right = seventh;
        
        levelOrder(myTree.root);
    }
}
