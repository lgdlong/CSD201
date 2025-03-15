/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author Legion 5 Pro
 */
public class OrderBST {
    TreeNode root;
    
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        double[] c = Lib.readLineToDoubleArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            Order newOrder = new Order(a[i], b[i], c[i]);
            insert(newOrder);
        }
    }
    
    public void insert(Order order){
        this.root = insert(this.root, order);
    }
    
    private TreeNode insert(TreeNode root, Order order){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (root == null) {
            return new TreeNode(order);
        }
        int idCompare = order.orderID.compareTo(root.info.orderID);
        if (idCompare < 0) {
            root.left = insert(root.left, order);
        } else if (idCompare > 0) {
            root.right = insert(root.right, order);
        } else {
            int nameCompare = order.customerName.compareTo(root.info.customerName);
            if (nameCompare < 0) {
                root.left = insert(root.left, order);
            } else if (nameCompare > 0) {
                root.right = insert(root.right, order);
            }
        }
        return root;
        //---------------------------------------------------------
    }
    
    public Order search(String id){
        return search(root, id);
    }
    
    public Order search(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (root == null) {
            return null;  // Explicitly return null if tree is empty or we've reached a leaf
        }
        int idCompare = id.compareTo(root.info.orderID);
        if (idCompare == 0) {
            return root.info;  // Found the order
        }
        if (idCompare < 0) {
            return search(root.left, id);  // Search left subtree
        }
        return search(root.right, id);  // Search right subtree
        //---------------------------------------------------------
    }
    
    public void remove(String id){
        root = remove(root, id);
    }
    
    public TreeNode remove(TreeNode root, String id){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (root == null) {
            return null;
        }
        int idCompare = id.compareTo(root.info.orderID);
        if (idCompare < 0) {
            root.left = remove(root.left, id);
        } else if (idCompare > 0) {
            root.right = remove(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode temp = findMinNode(root.right);
            root.info = temp.info;
            root.right = remove(root.right, temp.info.orderID);
        }
        return root;
        //---------------------------------------------------------
    }
    
    public Order findMax(){
        return findMax(root);
    }
    
    public Order findMax(TreeNode root){
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.info;
        //---------------------------------------------------------
    }
    
    private TreeNode findMinNode(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
