package src.graphs;
import java.util.LinkedList;
//this interface is used to represent the graph
//V is the type of the vertices
//E is the type of the edges
public interface Graph_Sec22_G15<V, E> {
    LinkedList<V> getVertices();    
    LinkedList<LinkedList<E>> getAdjacencyList();
    void addVertex(V vertex);
    V removeVertex(V vertex);
    void addEdge(E edge);
    void removeEdge(E edge);
    int centralityDegree(V vertex);
    LinkedList<V> vertexReachBfs(V start);
    LinkedList<V> vertexReachDfs(V start);
    int reachCount(V start);
    void printGraph();
}
