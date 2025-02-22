package Model;


public class SinglelyLinkedList {
    // Node class
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public void add(int value) {
        Node node = new Node(value);
        head = tail = node;
        size++;
    }
    
    public void addToHead(int value) {
        if (isEmpty()) {
            add(value);
            return;
        }
        
        // create new node and connect to old head
        Node newNode = new Node(value, head);
        
        // reasign head
        head = newNode;
        
        size++;
    }
    
    public void addToTail(int value) {
        // check is liked list empty or not?
        if (isEmpty()) {
            add(value);
            return;
        }
        
        Node newNode = new Node(value);
        
        // connect old tail to new node
        tail.next = newNode;
        
        // reasign the tail
        tail = newNode;
        
        size++;
    }
    
    
    public void addAfter(Node node  , int value) {
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
    
    
    
    public boolean isEmpty() {
        return size == 0 || head == null || tail == null;
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
