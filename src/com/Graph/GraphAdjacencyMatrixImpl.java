package com.Graph;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyMatrixImpl {
    public int nodes ;
    public int edges;

    public int[][] adjacencyMatrix;

    public GraphAdjacencyMatrixImpl(int nodes) {
        this.nodes = nodes;
        this.edges = 0;
        this.adjacencyMatrix = new int[nodes][nodes];
    }

    public void insertEdges(int vertex1 , int vertex2){
        // here we are making it a directed graph for undirected graph refer list implementation
        adjacencyMatrix[vertex1][vertex2] = 1;
        edges++;
    }
    public void print(){
        for(int i=0;i<nodes;i++){
            System.out.print(i+" "+":"+" ");
            for(int j=0;j<nodes;j++){
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    // in dfs traversal we take one node and go on in the depth of that one node as far as we can and then return and do the same on the previous nodes
    public void dfsTraversal(int edges , int nodes , int startVertex , boolean[] visited){
        System.out.print(startVertex+" ");  // first print the vertex we are currently at
        visited[startVertex] = true;  // now mark that vertex isited so that we do not visit it twice
        for(int i=0;i<nodes;i++){   // this loop is to go deep into all the vertices which are connected to the start vertex
            if(i==startVertex){
                continue;
            }
            else{
                if(adjacencyMatrix[startVertex][i]==1){  // if there is a coonection between the sv and the ith node then check whether we have already visited it or not
                    if(visited[i]==true){
                        continue;
                    }
                    else{  // if we have not visited it now make the ith vertex as the start vertex and recusively call the dfs function again
                        dfsTraversal(edges,nodes,i,visited);
                    }
                }
            }
        }
    }


    // start from the selected node and traverse the graph level wise explore all the nodes that are connected to the starting nodes and then move on to the other nodes
    public void bfsTraversal(int nodes , int sv , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()){ // till the size of the queue is not zero
            int currentVertex = q.peek(); // store the top element for printing it and for getting nodes directly connected to it
            q.poll();
            System.out.print(currentVertex+" ");
            for(int i=0;i<nodes;i++){ // here we will be checking for all the verties connected to the sv or the current vertex
                if(i==currentVertex){ // if i is same as current vertex continue the loop
                    continue;
                }
                // if i is not same as the current vertex check if the currentvertex and i have an edge b/w them and also that the ith node is not visited before
                else if(adjacencyMatrix[currentVertex][i]==1 && !visited[i]){
                    q.add(i); // if yes then push it into the queue and mark the ith node as visited
                    visited[i] = true;
                }
            }
        }


    }
}
