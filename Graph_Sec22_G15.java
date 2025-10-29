import java.util.LinkedList;

public interface Graph_Sec22_G15<V, E> {
    LinkedList<V> getVertices();    
    LinkedList<LinkedList<E>> getAdjacencyList();
    void addVertex(V vertex);
    V removeVertex(V vertex);
    void addEdge(V v1, V v2, String label);
    void removeEdge(V v1, V v2, String label);
    int neighborsCount(V vertex);
    int reachCount(V start);
    void printGraph();
}
