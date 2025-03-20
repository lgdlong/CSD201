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
        
        Room r = new Room(code, status, size, price);
        Node newNode = new Node(r);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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
        if (size <= 0 || price <= 0) return;
        
        Room r = new Room(size, price);
        Node newNode = new Node(r);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
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
            return null;
        }
        tmp = front.info;
        front = front.next;
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
        Room bestRoom = null;
        int lowestPrice = Integer.MAX_VALUE;
        
        Node current = dList.head;
        
        while (current != null) {
            Room r = current.info;
            if (r.getStatus() == 0 && r.getSize() >= t.getSize() && r.getPrice() <= t.getPrice()) 
            {
                if (r.getPrice() <= lowestPrice) {
                    lowestPrice = r.getPrice();
                    bestRoom = r;
                }
            }
            current = current.next;
        }
        
        if (bestRoom != null) {
            bestRoom.setStatus(1);
        }
        //---------------------------------------------------------
    }
    
    int rent_mo(Room t) throws Exception {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        
        int money = 0;
        
        Room bestRoom = null;
        int lowestPrice = Integer.MAX_VALUE;
        
        Node current = dList.head;
        
        while (current != null) {
            Room r = current.info;
            if (r.getStatus() == 0 && r.getSize() >= t.getSize() && r.getPrice() <= t.getPrice()) 
            {
                if (r.getPrice() <= lowestPrice) {
                    lowestPrice = r.getPrice();
                    bestRoom = r;
                }
            }
            current = current.next;
        }
        
        if (bestRoom != null) {
            money = bestRoom.getPrice();
            bestRoom.setStatus(1);
        }
        return money;
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
        rent(RQueue.deQueue());
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
        while (!RQueue.isEmpty()) {
            rent(RQueue.deQueue());
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
        while (!RQueue.isEmpty()) {
            result += rent_mo(RQueue.deQueue());
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.writeBytes("Total Revenue: " + result + " ");
        f.close();
    }

}
