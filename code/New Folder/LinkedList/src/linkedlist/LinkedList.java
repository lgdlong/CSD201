package linkedlist;

public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public void addLast(int value) {
        // check head already or not?
        if (head == null) {
            add(value);
            return;
        }
        
        Node newNode = new Node(value);
        
        tail.setNext(newNode);
        
        // reasign
        tail = tail.getNext();
        
        size++;
    }
    
    public void addFirst(int value) {
        if (head == null) {
            add(value);
            return;
        }
        
        Node newNode = new Node(value, head);
        
        head = newNode;
        
        size++;
    }
    
    public Node deleteFirst() {
        if (size == 0) {
            tail = null;
        }
        
        Node temp = head.getNext();
        head = head.getNext();
        size--;
        
        return temp;
    }
    
    public Node deleteLast() {
        if (size == 0) {
            System.out.println("empty list.");
            return null;
        }
        
        if (size == 1) {
            Node temp = head;
            
            head = null;
            tail = null;
            size--;
            
            return temp;
        }
        
        // traversal
        Node pointer = head;
        
        while (pointer.getNext() != tail) {
            pointer = pointer.getNext();
        }
        
        Node temp = pointer;
        pointer.setNext(null);
        tail = pointer;
        size--;
        
        return temp;
    }
    
    public void addAtPosition(int value, int position) {
        int length = size;
        
        if (position < 0 && position > length) {
            System.out.println("Index invalid!");
            return;
        }
        if (head == null) {
            add(value);
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == length) {
            addLast(value);
            return;
        }
        
        Node current = head;
        int index = 0;
        /*
        After loop current will berofe the position
        
        */
        while (current != null && index < position-1) {
            current = current.getNext();
            index++;
        }
       
        
        Node newNode = new Node(value, current.getNext());
        
        current.setNext(newNode);
    }
    
    public Node deleteAtPosition(int position) {
        if (position < 0 || position >= size) { // Check for invalid position
            System.out.println("Invalid position!");
            return null;
        }
        
        if (position == 0) {
            return deleteFirst();
        }
        
        if (size == 0) {
            System.out.println("There no node");
            return null;
        }
        
        if (position == size-1) {
            return deleteLast();
        }
        
        
        Node pointer = head;
        
        int place = 0;
        while (place < position-1) {
            pointer = pointer.getNext();
            place++;
        }
        
        // get delete node and point next to null
        Node deleteNode = pointer.getNext();
        
        // set pointer next to after delete node
        pointer.setNext(deleteNode.getNext());
        
        size--;
        return deleteNode;
    }
    
    public void add(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        size++;
    }
    
    public void printLinkedList() {
        Node pointer = head; // assign address of head to pointer.
        
        while (pointer != null) {
            System.out.print(pointer.getValue() + " -> ");
            pointer = pointer.getNext();
        }
        
        if (pointer == null) System.out.print("null\n");
        
        System.out.println("Size: " + size);
    }
    
}
