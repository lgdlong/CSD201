/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Program {
    public static void main(String[] args) {
        QueueLinkedList lk = new QueueLinkedList();
        
        String r = "EAS*Y*QUE***ST***IO*N*";
        char[] rr = r.toCharArray();
        Queue<Character> q = new ArrayDeque<Character>();
        
        for (char f:rr) {
            if (f == '*') {
                q.remove();
            } else {
                q.add(f);
            }
        }
        
        System.out.println(q);
    }
}
