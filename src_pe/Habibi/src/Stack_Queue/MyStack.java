public class MyStack {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public MyStack() {
        top = null;
    }

    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Object data = top.data;
        top = top.next;
        return data;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push("two");
        stack.push(3.14);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        stack.display();
    }
}