import java.util.LinkedList;

public interface Graph_Sec22_G15<V, E> {
    LinkedList<V> getVertices();    
    LinkedList<LinkedList<E>> getAdjacencyList();
    void addVertex(V vertex);
    V removeVertex(V vertex);
    void addEdge(E edge);
    void removeEdge(E edge);
    int centralityDegree(V vertex);
    LinkedList<V> vertexReach(V start);
    int reachCount(V start);
    void printGraph();
}
