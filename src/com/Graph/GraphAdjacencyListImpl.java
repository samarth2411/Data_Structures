package com.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyListImpl {

    public int vertices ;
    public int edges ;

    public LinkedList<Integer>[] adjacencyLists;

    public GraphAdjacencyListImpl(int vertices) {
        this.vertices = vertices;
        this.edges = 0;

        // creating a adjacency list so that it can store all the edges connected to a particular vertex
        this.adjacencyLists = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            // creating a new linked list at every vertex in adjacencylist to , the corresponding list to every vertex will store the edges connected to that vertex
            adjacencyLists[i] = new LinkedList<>();
        }

    }

    public void insert(int vertex1 , int vertex2){
        adjacencyLists[vertex1].add(vertex2);
        // as it is an undirected graph so we will connect the edges both ways . if it would have been an directed graph we need to then specify the connections seperately
        adjacencyLists[vertex2].add(vertex1);
    }

    public void print(){
        for(int i=0;i<vertices;i++){
            System.out.print(i+" "+":"+" ");
            for(int j=0;j<adjacencyLists[i].size();j++){
                System.out.print(adjacencyLists[i].get(j)+" ");
            }
            System.out.println();
        }
    }

    public void bfs( int sv , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while(!q.isEmpty()){
            int currentVertex = q.poll();
            System.out.print(currentVertex+" ");
            for(int i=0;i<adjacencyLists[currentVertex].size();i++){
                if(adjacencyLists[currentVertex].get(i)==i){
                    continue;
                }
                else{
                    if(!visited[adjacencyLists[currentVertex].get(i)]){
                        q.add(adjacencyLists[currentVertex].get(i));
                        visited[adjacencyLists[currentVertex].get(i)] = true;
                    }
                }
            }
        }


    }
    public void dfsIterative(int sv , boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(sv);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u+" ");
                for(int v: adjacencyLists[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }
}
