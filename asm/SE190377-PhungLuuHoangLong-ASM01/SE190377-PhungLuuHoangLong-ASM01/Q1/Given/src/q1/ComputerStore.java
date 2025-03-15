package q1;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class ItemList {

    Node head, tail;

    ItemList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataItem(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    void addLast(String name, int quantity, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Item newitem = new Item(name, quantity, price);
        Node newnode = new Node(newitem);
        if (head == null) {
            head = newnode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newnode;
        //---------------------------------------------------------
    }

}

class RequestQueue {

    Node front, rear;

    RequestQueue() {
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
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String name, int quantity) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Item newitem = new Item(name, quantity);
        Node newnode = new Node(newitem);
        if (rear == null) {
            front = rear = newnode;
            return;
        }
        rear.next = newnode;
        rear = newnode;
        //---------------------------------------------------------
    }

    Item deQueue() {
        Item tmp = new Item();
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

class ComputerStore {

    ItemList IList = new ItemList();
    RequestQueue RQueue = new RequestQueue();

    ComputerStore() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = IList.head;
        f.writeBytes("Data Item: ");
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request   : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        IList.loadDataItem(k);
        RQueue.loadDataRequest(k);
    }

//===========================================================================
//=======YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
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

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!RQueue.isEmpty()) {
            Item requestItem = RQueue.deQueue(); // Lấy yêu cầu đầu tiên
            processPurchase(requestItem);
        }
        //------------------------------------------------------------------------------------
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        while (!RQueue.isEmpty()) {
            Item requestItem = RQueue.deQueue();
            processPurchase(requestItem);
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    int processPurchase(Item requestItem) {
        int S = 0;
        
        String itemName = requestItem.getName();
        int requestedQuantity = requestItem.getQuantity();

        Node currentItem = IList.head;
        while (currentItem != null) {
            if (currentItem.info.getName().equals(itemName)) {
                int availableQuantity = currentItem.info.getQuantity();
                if (availableQuantity >= requestedQuantity) {
                    currentItem.info.setQuantity(availableQuantity - requestedQuantity);
                    S += currentItem.info.getPrice()*requestItem.getQuantity();
                }
                break;
            }
            currentItem = currentItem.next;
        }
        
        return S;
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        int S = 0;
        while (!RQueue.isEmpty()) {
            Item requestItem = RQueue.deQueue();
             S += processPurchase(requestItem);
        }
        //------------------------------------------------------------------------------------
        f.writeBytes("Money     : " + S + " ");
        f.close();
    }
}
