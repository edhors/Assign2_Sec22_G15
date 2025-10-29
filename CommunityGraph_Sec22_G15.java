import java.util.LinkedList;
import java.util.Queue;

public class CommunityGraph_Sec22_G15 extends AbstractGraph_Sec22_G15<Contributor_Sec22_G15, Collaboration_Sec22_G15> {
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

    @Override
    public void addVertex(Contributor_Sec22_G15 contributor) {
        try {
            for(Contributor_Sec22_G15 c : vertices) {
                if(c.getId().equals(contributor.getId())) {
                    throw new DuplicateId_Sec22_G15(contributor.getId());
                }
            }
        } catch (DuplicateId_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        vertices.add(contributor);
        adjacencyList.add(new LinkedList<>());
    }

    @Override
    public Contributor_Sec22_G15 removeVertex(Contributor_Sec22_G15 contributor) {
        int index = vertices.indexOf(contributor);
        try {
            if (index == -1) {
                throw new ContributorNotFound_Sec22_G15(contributor.getName());
            }
        } catch (ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        //remove all edges connected to this vertex
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (i != index && adjacencyList.get(i).contains(contributor)) {
                adjacencyList.get(i).remove(contributor);
            }
        }
        
        //remove the vertex and its adjacency list
        vertices.remove(index);
        adjacencyList.remove(index);
        return contributor;
    }

    @Override
    public void addEdge(Contributor_Sec22_G15 c1, Contributor_Sec22_G15 c2, String projectId) {
        int index1 = vertices.indexOf(c1);
        int index2 = vertices.indexOf(c2);
    
        try {
            if (index1 == -1 || index2 == -1) {
                throw new ContributorNotFound_Sec22_G15(c1.getName() + " or Contributor " + c2.getName());
            }
        } catch (ContributorNotFound_Sec22_G15 e) {
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
    
    @Override
    public void removeEdge(Contributor_Sec22_G15 c1, Contributor_Sec22_G15 c2, String projectId) {
        int index1 = vertices.indexOf(c1);
        int index2 = vertices.indexOf(c2);
    
        try {
            if (index1 == -1 || index2 == -1) {
                throw new ContributorNotFound_Sec22_G15(c1.getName() + " or Contributor " + c2.getName());
            }
        } catch (ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        //remove the collaborations from both adjacency lists (undirected graph)
        adjacencyList.get(index1).remove(new Collaboration_Sec22_G15(c1, c2, projectId));
        adjacencyList.get(index2).remove(new Collaboration_Sec22_G15(c2, c1, projectId));
    }

    @Override
    public void printGraph() {
        for(Contributor_Sec22_G15 currentVertex : vertices) {
            System.out.print(currentVertex.toString());
            int index = vertices.indexOf(currentVertex);
            for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                System.out.print(" -> " + currentEdge.getContributor2().toString() + " (" + currentEdge.getProjectId() + ")");
            }
            System.out.println();
        }    
    }
    @Override
    public int neighborsCount(Contributor_Sec22_G15 vertex) {
        int index = vertices.indexOf(vertex);
        return adjacencyList.get(index).size();
    }
    
    @Override
    public int reachCount(Contributor_Sec22_G15 start) {
        try {
            if (!vertices.contains(start)) {
                throw new ContributorNotFound_Sec22_G15(start.toString());
            }
        } catch(ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return 0;
        }
        
        LinkedList<Contributor_Sec22_G15> visited = new LinkedList<>();
        Queue<Contributor_Sec22_G15> queue = new LinkedList<>();
        
        visited.add(start);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            Contributor_Sec22_G15 current = queue.poll();            
            int index = vertices.indexOf(current);
            for (Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                Contributor_Sec22_G15 neighbor = currentEdge.getContributor2();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited.size();
    }   
}