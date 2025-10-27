import java.util.LinkedList;

public class CommunityGraph_Sec22_G15 {
    private LinkedList<Contributor_Sec22_G15> vertices;
    private LinkedList<LinkedList<Collaboration_Sec22_G15>> adjacencyList;

    public CommunityGraph_Sec22_G15() {
        this.vertices = new LinkedList<>();
        this.adjacencyList = new LinkedList<>();
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<>();
        while (adjacencyList.size() < vertices.size()) {
            adjacencyList.add(new LinkedList<Collaboration_Sec22_G15>());
        }
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices, LinkedList<LinkedList<Collaboration_Sec22_G15>> adjacencyList) {
        this.vertices = vertices;
        this.adjacencyList = adjacencyList;
    }

    public LinkedList<Contributor_Sec22_G15> getVertices() {
        return this.vertices;
    }

    public LinkedList<LinkedList<Collaboration_Sec22_G15>> getAdjacencyList() {
        return this.adjacencyList;
    }


    public void addEdge(Contributor_Sec22_G15 c1, Contributor_Sec22_G15 c2, String projectId) {
        int index1 = vertices.indexOf(c1);
        int index2 = vertices.indexOf(c2);
    
        if (index1 == -1 || index2 == -1) {
            System.out.println("One or both contributors not found!");
            return;
        }
    
        //create collaboration objects (edges)
        Collaboration_Sec22_G15 collaboration1 = new Collaboration_Sec22_G15(c1, c2, projectId);
        Collaboration_Sec22_G15 collaboration2 = new Collaboration_Sec22_G15(c2, c1, projectId);
    
        //add the collaborations to both adjacency lists (undirected graph)
        adjacencyList.get(index1).add(collaboration1);
        adjacencyList.get(index2).add(collaboration2);
    }
    
    public void removeEdge(Contributor_Sec22_G15 c1, Contributor_Sec22_G15 c2, String projectId) {
        int index1 = vertices.indexOf(c1);
        int index2 = vertices.indexOf(c2);
    
        if (index1 == -1 || index2 == -1) {
            System.out.println("One or both contributors not found!");
            return;
        }
    }

    public void removeVertex(Contributor_Sec22_G15 contributor) {
        int index = vertices.indexOf(contributor);
    
        if (index == -1) {
            System.out.println("Contributor not found!");
            return;
        }
    }

    public void printGraph() {
        for(Contributor_Sec22_G15 currentVertex : vertices) {
            System.out.print(currentVertex.getName() + " -> ");
            for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(vertices.indexOf(currentVertex))) {
                System.out.print(currentEdge.getContributor2().getName());
                if(currentEdge != adjacencyList.get(vertices.indexOf(currentVertex)).getLast()) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }    
    }
    
    
    
}