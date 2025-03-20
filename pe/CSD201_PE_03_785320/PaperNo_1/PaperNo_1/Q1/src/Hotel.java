
import java.util.*;
import java.io.*;

class dataList {

    Node head, tail;

    dataList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataRoom(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int[] d = Lib.readLineToIntArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i], d[i]);
        }
    }

    void addLast(String code, int status, int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (size <= 0 || price <= 0) {
            return;
        }
        Room newRoom = new Room(code, status, size, price);

        // Create a new Node to hold the Room object
        Node newNode = new Node(newRoom);

        // If the list is empty, set head and tail to the new node
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // Otherwise, append the new node to the end and update tail
            tail.next = newNode;
            tail = newNode;
        }
        //---------------------------------------------------------
    }

}

class requestQueue {

    Node front, rear;

    requestQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    void loadDataRequest(int k) //do not edit this function
    {
        int[] a = Lib.readLineToIntArray("data.txt", k + 4);
        int[] b = Lib.readLineToIntArray("data.txt", k + 5);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (size <= 0 || price <= 0) {
            return;
        }

        Room room = new Room(size, price);
        Node newNode = new Node(room);

        // If the queue is empty, set both front and rear to the new node
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            // Otherwise, link the new node to the rear and update rear
            rear.next = newNode;
            rear = newNode;
        }
        //---------------------------------------------------------
    }

    Room deQueue() {
        Room tmp = new Room();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        if (isEmpty()) {
            return null; // Return null if the queue is empty
        }

        tmp = front.info; // Retrieve the Room object in the front node

        // Move the front pointer to the next node
        front = front.next;

        // If the queue becomes empty, set rear to null
        if (front == null) {
            rear = null;
        }

        //---------------------------------------------------------
        return tmp;
    }

}

class Hotel {

    dataList dList = new dataList();
    requestQueue RQueue = new requestQueue();

    Hotel() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = dList.head;
        f.writeBytes("Data List: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request  : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getSize() + "," + p.info.getPrice() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        dList.loadDataRoom(k);
        RQueue.loadDataRequest(k);
    }

    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    void rent(Room t) throws Exception {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node bestRoomNode = null;
        int bestPrice = Integer.MAX_VALUE; // Start with the highest possible price
        Node current = dList.head;

        // Iterate through the list to find the best room
        while (current != null) {
            Room room = current.info;
            if (room.getStatus() == 0 && room.getSize() > t.getSize() && room.getPrice() <= t.getPrice()) {
                // Check if the current room is better
                if (room.getPrice() < bestPrice || (room.getPrice() == bestPrice && current != null)) {
                    bestRoomNode = current;
                    bestPrice = room.getPrice();
                }
            }
            current = current.next;
        }

        // If a best room is found, update its status to rented
        if (bestRoomNode != null) {
            bestRoomNode.info.setStatus(1); // Mark the room as rented
        }
        //---------------------------------------------------------
    }

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        // Process the first request using deQueue() and rent()
        Room request = RQueue.deQueue();
        if (request != null) {
            rent(request);
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Room request;
        while ((request = RQueue.deQueue()) != null) {
            rent(request);
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int result = 0;
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Room request;
        while ((request = RQueue.deQueue()) != null) {
            rent(request); // Rent rooms based on requests
        }

        Node current = dList.head;
        while (current != null) {
            Room room = current.info;
            if (room.getStatus() == 1) { // Only include rented rooms
                result += room.getPrice();
            }
            current = current.next;
        }

        //---------------------------------------------------------
        ftraverse(f);
        f.writeBytes("Total Revenue: " + result + " ");
        f.close();
    }

}
