/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

import java.util.EmptyStackException;

/**
 *
 * @author ADMIN
 */
public class StackLinkedList {
    
    private Node top;
    private int length;
    
    public StackLinkedList() {
        this.top = null;
        this.length = 0;
    }
    
    public int length() {
        return this.length;
    }
    
    public boolean isEmpty() {
        return this.length == 0;
    }
    
    public void push(int value) {
        Node newNode = new Node(value);
        
        if (this.isEmpty()) {
            init(value);
            return;
        }
        
        newNode.setNext(this.top);
        this.top = newNode;
        
        length++;
    }
    
    public Node pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        
        Node data = top;
        this.top = top.getNext();
        
        data.setNext(null);
        
        length--;
        
        return data;
    }
    
    
    
    public void init(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        length++;
    }
    
    public Node peek() {
        return this.top;
    }
    
    public void printStack() {
        Node pointer = top; // assign address of head to pointer.
        
        while (pointer != null) {
            System.out.print(pointer.getValue() + " -> ");
            pointer = pointer.getNext();
        }
        
        if (pointer == null) System.out.print("null\n");
        
        System.out.println("Size: " + length());
    }
}
