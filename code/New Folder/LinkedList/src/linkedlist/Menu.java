package linkedlist;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(LinkedList linkedList){
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- Linked List ---");
            System.out.println("1. Add value last");
            System.out.println("2. Add value first");
            System.out.println("3. Print all value");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        
            switch (choice) {
                case 1:
//                    linkedList.addLast();
                    break;
                case 2:
//                    linkedList.addFirst();
                    break;
                case 3:
                    linkedList.printLinkedList();
                    break;
                case 0:
                    
                    break;
            }
        } while (choice != 0);
    }
    
   
}
