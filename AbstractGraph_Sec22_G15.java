import java.util.LinkedList;

public abstract class AbstractGraph_Sec22_G15<V, E> implements Graph_Sec22_G15<V, E>{
    protected LinkedList<V> vertices;
    protected LinkedList<LinkedList<E>> adjacencyList;

    public AbstractGraph_Sec22_G15() {
        this.vertices = new LinkedList<>();
        this.adjacencyList = new LinkedList<>();
    }

    public AbstractGraph_Sec22_G15(LinkedList<V> vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<>();
        while (adjacencyList.size() < vertices.size()) {
            adjacencyList.add(new LinkedList<E>());
        }
    }

    public AbstractGraph_Sec22_G15(LinkedList<V> vertices, LinkedList<LinkedList<E>> adjacencyList) {
        this.vertices = vertices;
        this.adjacencyList = adjacencyList;
    }

    public LinkedList<V> getVertices() {
        return this.vertices;
    }

    public LinkedList<LinkedList<E>> getAdjacencyList() {
        return this.adjacencyList;
    }

    public abstract void addVertex(V vertex);
    public abstract V removeVertex(V vertex);
    public abstract void addEdge(V v1, V v2, String label);
    public abstract void removeEdge(V v1, V v2, String label);
    public abstract int centralityDegree(V vertex);
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
