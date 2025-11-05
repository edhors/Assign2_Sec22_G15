/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.graphs;
import java.util.LinkedList;
//this class is used to represent the abstract graph
//V is the type of the vertices
//E is the type of the edges
public abstract class AbstractGraph_Sec22_G15<V, E> implements Graph_Sec22_G15<V, E>{
    protected LinkedList<V> vertices;
    protected LinkedList<LinkedList<E>> adjacencyList;

    //this constructor is used to create a new graph with no vertices or edges
    public AbstractGraph_Sec22_G15() {
        this.vertices = new LinkedList<>();
        this.adjacencyList = new LinkedList<>();
    }

    //this constructor is used to create a new graph with a list of vertices
    public AbstractGraph_Sec22_G15(LinkedList<V> vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<>();
        //add an empty list of edges to the adjacency list for each vertex
        while (adjacencyList.size() < vertices.size()) {
            adjacencyList.add(new LinkedList<E>());
        }
    }

    //this constructor is used to create a new graph with a list of vertices and a list of edges
    public AbstractGraph_Sec22_G15(LinkedList<V> vertices, LinkedList<LinkedList<E>> adjacencyList) {
        this.vertices = vertices;
        this.adjacencyList = adjacencyList;
    }

    //this method is used to get the list of vertices
    public LinkedList<V> getVertices() {
        return this.vertices;
    }

    //this method is used to get the list of edges
    public LinkedList<LinkedList<E>> getAdjacencyList() {
        return this.adjacencyList;
    }

    public abstract void addVertex(V vertex);
    public abstract V removeVertex(V vertex);
    public abstract void addEdge(E edge);
    public abstract void removeEdge(E edge);
    public abstract int centralityDegree(V vertex);
    public abstract LinkedList<V> vertexReachBfs(V start);
    public abstract LinkedList<V> vertexReachDfs(V start);
    public abstract int reachCount(V start);
    
    
    @Override
    public void printGraph() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).toString());
            for (E edge : adjacencyList.get(i)) {
                System.out.print(" -> " + edge.toString());
            }
            System.out.println();
        }
    }
}
