package Stack_Queue;

public class MyQueue {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public MyQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Object data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue("two");
        queue.enqueue(3.14);
        queue.display();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.display();
    }
}
