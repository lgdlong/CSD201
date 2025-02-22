package linkedlist;

import java.util.EmptyStackException;


public class QueueLinkedList {
    private Node front;
    private int length;
    
    public QueueLinkedList() {
        this.front = null;
        this.length = 0;
    }
    
    public int length() {
        return this.length;
    }
    
    public boolean isEmpty() {
        return this.length == 0;
    }
    
    public void enqueue(int value) {
        Node newNode = new Node(value);
        
        if (isEmpty()) {
            init(value);
            return;
        }
        
        Node currNode = this.front;
        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }
        currNode.setNext(newNode);
        length++;
    }
    
    public Node dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = front;
        front = front.getNext();
        length--;
        temp.setNext(null);
        
        return temp;
    }
    
    public Node peek() {
        return this.front;
    }
    
    private void init(int value) {
        Node newNode = new Node(value);
        front = newNode;
        length++;
    }
    
    public void printQueue() {
        Node pointer = front; // assign address of head to pointer.
        
        while (pointer != null) {
            System.out.print(pointer.getValue() + " -> ");
            pointer = pointer.getNext();
        }
        
        if (pointer == null) System.out.print("null\n");
        
        System.out.println("Size: " + length());
    }
}
