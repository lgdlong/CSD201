/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graph;

import java.util.LinkedList;

/**
 *
 * @author Legion 5 Pro
 */
public class Graph {
    private int vertices; // number of nodes
    private int[][] adjMatrix; //adjacency matrix
    private LinkedList<Integer>[] adjList;
    
    public Graph(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        adjList = new LinkedList[vertices];
        
        //Initialize every adjacency list
        for(int i = 0; i < vertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int source, int destination){
        adjMatrix[source][destination] = 1; //connect source to destination
        adjMatrix[destination][source] = 1; //connect destination to source (undirected)
        adjList[source].add(destination);
        adjList[destination].add(source);
    }
    
    public void removeEdge(int source, int destination){
        adjMatrix[source][destination] = 0; //disconnect source to destination
        adjMatrix[destination][source] = 0; //disconnect destination to source (undirected)
    }
    
    public void printGraphMatrix(){
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < vertices; i++){
            for (int j = 0; j < vertices; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
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
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        
        graph.printGraphMatrix();
        graph.printGrapthList();
    }
}
