package linkedlist;

public class Node {
    private int value;
    private Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    
    public Node(int value, Node newNode) {
        this.value = value;
        this.next = newNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
