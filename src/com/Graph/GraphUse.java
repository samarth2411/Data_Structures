package com.Graph;

import java.util.Scanner;

public class GraphUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vertices in the graph");
        int vertices = sc.nextInt();
        System.out.println("Enter the edges in the graph");
        int edges = sc.nextInt();

        GraphAdjacencyListImpl obj = new GraphAdjacencyListImpl(vertices);

        GraphAdjacencyMatrixImpl obj2 = new GraphAdjacencyMatrixImpl(vertices);

        if(edges > (vertices*(vertices-1))/2){
            System.err.println("Edges are greater than vertices ; Graph not possible");
        }
        else{

            // FOR LIST IMPLEMENTATION

            for(int i=0;i<edges;i++){
                System.out.println("Enter the connected vertices");
                int vertex1 = sc.nextInt();
                int vertex2 = sc.nextInt();
                obj.insert(vertex1,vertex2);
            }
//            obj.print();
            boolean[] visited = new boolean[vertices];
              obj.dfsIterative(0,visited);

            // FOR MATRIX IMPLEMENTATION

//            for(int i=0;i<edges;i++){
//                System.out.println("Enter the connected nodes");
//                int node1 = sc.nextInt();
//                int node2 = sc.nextInt();
//                obj2.insertEdges(node1,node2);
//            }
        }
//        boolean[] visited = new boolean[vertices];
////        obj2.dfsTraversal(edges,vertices,0,visited);
////        System.out.println();
//        obj.bfs(0,visited);
//        System.out.println();
    }
}
