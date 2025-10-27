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
    
        try {
            if (index1 == -1 || index2 == -1) {
                throw new ContributorNotFound();
            }
        } catch (ContributorNotFound e) {
            System.out.println(e.getMessage());
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
    
        try {
            if (index1 == -1 || index2 == -1) {
                throw new ContributorNotFound();
            }
        } catch (ContributorNotFound e) {
            System.out.println(e.getMessage());
            return;
        }
        //remove the collaborations from both adjacency lists (undirected graph)
        adjacencyList.get(index1).remove(new Collaboration_Sec22_G15(c1, c2, projectId));
        adjacencyList.get(index2).remove(new Collaboration_Sec22_G15(c2, c1, projectId));
    }

    public void addVertex(Contributor_Sec22_G15 contributor) {
        vertices.add(contributor);
        adjacencyList.add(new LinkedList<>());
    }

    public void removeVertex(Contributor_Sec22_G15 contributor) {
        vertices.remove(contributor);
        adjacencyList.remove(vertices.indexOf(contributor));
    }

    public void printGraph() {
        for(Contributor_Sec22_G15 currentVertex : vertices) {
            System.out.print(currentVertex.getName() + " -> ");
            for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(vertices.indexOf(currentVertex))) {
                System.out.print(currentEdge.getContributor2().getName() + " (" + currentEdge.getProjectId() + ")");
                if(currentEdge != adjacencyList.get(vertices.indexOf(currentVertex)).getLast()) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }    
    }
    
    
    
}