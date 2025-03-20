/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bfs;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Legion 5 Pro
 */
public class BFS {
    private int vertices;
    private LinkedList<Integer>[] adjList;
    
    public BFS(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        //Initialize every adjacency list
        for(int i = 0; i < vertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }
    
    public void bfs(int source){
        boolean[] isVisited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        isVisited[source] = true;
        
        while(!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source + " ");
            for (int neighbor : adjList[source]){
                if(!isVisited[neighbor]){
                    queue.add(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }
    }
    
    public void dfs(int source){
        boolean[] isVisited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(source);
        
        while(!stack.isEmpty()){
            source = stack.pop();
            if(!isVisited[source]){
                System.out.print(source + " ");
                isVisited[source] = true;
            }
            for(int neighbor : adjList[source]){
                if(!isVisited[neighbor]){
                    stack.push(neighbor);
                }
            }   
        }
    }
    
    public void printGrapthList(){
        System.out.println("Adjacency List");
        for(int i = 0; i < vertices; i++){
            System.out.print("Vertex " + i + ":");
            for (Integer element : adjList[i]){
                System.out.print(" -> "+ element);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        BFS graph = new BFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        
        graph.printGrapthList();
        System.out.println("Breadth-First Search: ");
        graph.bfs(1);
        System.out.println("");
        System.out.println("Depth-First Search: ");
        graph.dfs(1);
    }
}
