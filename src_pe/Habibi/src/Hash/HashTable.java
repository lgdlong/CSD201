package Hash;

public class HashTable {

    private class HashNode {

        private Integer key; // Can be generic
        private String value; // Can be generic
        private HashNode next;// Reference to the next HashNode

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode[] buckets;
    private int numOfBuckets; // capacity
    private int size; // number of key-value pairs in HashTable or number of Hash Nodes

    public HashTable() {
        this(10); // default capacity
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(Integer key) {
        return key % numOfBuckets; // buckets.length
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value); // (key, value) -> null
        node.next = head; // link current node to be the next of the new node
        buckets[bucketIndex] = node; // insert at head
    }

    public String get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public String remove(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex]; // (21, "Tom") -> (31, "Harry") -> (41, "Sana") -> null
        HashNode previous = null;

        while (head != null) {
            if (head.key.equals(key)) { // as soon as we found the key ->
                break; // -> we break from this while loop and continue below
            }
            previous = head;
            head = head.next;
        }
        if (head == null) { // could not find that key
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;

        } else { // key is first node
            buckets[bucketIndex] = head.next; // remove first node
        }
        return head.value;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Harry");
        table.put(31, "Daniel");
        System.out.println(table.size());

        System.out.println(table.remove(21));
        System.out.println(table.remove(31));
        System.out.println(table.size()); // should be 1        
    }
}
