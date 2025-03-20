package LinkedList;

class SinglyLinkedList {
    // Node class for Singly Linked List
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Insert at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete a node with given data
    public void deleteNode(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Search for a node with given data
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addFirst(0);
        list.display(); // Output: 0 -> 1 -> 2 -> null
        list.deleteNode(1);
        list.display(); // Output: 0 -> 2 -> null
        System.out.println("Search 2: " + list.search(2)); // Output: true
    }
}