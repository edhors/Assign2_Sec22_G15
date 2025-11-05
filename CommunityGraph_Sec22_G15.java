import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommunityGraph_Sec22_G15 extends AbstractGraph_Sec22_G15<Contributor_Sec22_G15, Collaboration_Sec22_G15> {
    private LinkedList<Cluster_Sec22_G15> clusters;

    public CommunityGraph_Sec22_G15() {
        super(new LinkedList<>(), new LinkedList<>());
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices) {
        super(vertices, new LinkedList<>());
        while (adjacencyList.size() < vertices.size()) {
            adjacencyList.add(new LinkedList<Collaboration_Sec22_G15>());
        }
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices, LinkedList<LinkedList<Collaboration_Sec22_G15>> adjacencyList) {
        super(vertices, adjacencyList);
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
        
        LinkedList<Collaboration_Sec22_G15> edgesToRemove = new LinkedList<>(adjacencyList.get(index));
        for(Collaboration_Sec22_G15 currentEdge : edgesToRemove) {
            removeEdge(currentEdge);
        }
        
        vertices.remove(index);
        adjacencyList.remove(index);
        return contributor;
    }

    @Override
    public void addEdge(Collaboration_Sec22_G15 collaboration) {
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        Contributor_Sec22_G15 c2 = collaboration.getContributor2();
        String projectId = collaboration.getProjectId();

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

        Collaboration_Sec22_G15 otherCollaboration = new Collaboration_Sec22_G15(c2, c1, projectId);
    
        adjacencyList.get(index1).add(collaboration);
        adjacencyList.get(index2).add(otherCollaboration);
        
    }
    
    @Override
    public void removeEdge(Collaboration_Sec22_G15 collaboration) {
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        Contributor_Sec22_G15 c2 = collaboration.getContributor2();
        String projectId = collaboration.getProjectId();

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

        Collaboration_Sec22_G15 otherCollaboration = new Collaboration_Sec22_G15(c2, c1, projectId);
        try {
            if (!adjacencyList.get(index1).contains(collaboration) || !adjacencyList.get(index2).contains(otherCollaboration)) {
                throw new CollaborationNotFound_Sec22_G15(collaboration);
            }
        } catch (CollaborationNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        
        adjacencyList.get(index1).remove(collaboration);
        adjacencyList.get(index2).remove(otherCollaboration);
    }

    @Override
    public void printGraph() {
        for(Contributor_Sec22_G15 currentVertex : vertices) {
            System.out.print(currentVertex.toString() + " Collaborations: ");
            int index = vertices.indexOf(currentVertex);
            for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                System.out.print(" " + currentEdge.getContributor2().toString() + " (" + currentEdge.getProjectId() + ")");
            }
            System.out.println();
        }    
    }
    
    @Override
    public int centralityDegree(Contributor_Sec22_G15 vertex) {
        int index = vertices.indexOf(vertex);
        if (index == -1){ return 0;}
        return adjacencyList.get(index).size();
    }

    @Override
    public LinkedList<Contributor_Sec22_G15> vertexReachBfs(Contributor_Sec22_G15 start) {
        try {
            if (!vertices.contains(start)) {
                throw new ContributorNotFound_Sec22_G15(start.toString());
            }
        } catch(ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
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
        return visited;
    }

    @Override
    public LinkedList<Contributor_Sec22_G15> vertexReachDfs(Contributor_Sec22_G15 start) {
        try {
            if (!vertices.contains(start)) {
                throw new ContributorNotFound_Sec22_G15(start.toString());
            }
        } catch(ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        LinkedList<Contributor_Sec22_G15> visited = new LinkedList<>();
        Stack<Contributor_Sec22_G15> stack = new Stack<>();
        
        visited.add(start);
        stack.add(start);
        
        while (!stack.isEmpty()) {
            Contributor_Sec22_G15 current = stack.pop();            
            int index = vertices.indexOf(current);
            for (Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                Contributor_Sec22_G15 neighbor = currentEdge.getContributor2();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return visited;
    }

    @Override
    public int reachCount(Contributor_Sec22_G15 start) {
        LinkedList<Contributor_Sec22_G15> visited = vertexReachBfs(start);
        if (visited == null) {
            return 0;
        }
        return visited.size();
    }   

    public boolean isBridge(Collaboration_Sec22_G15 collaboration) {
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        LinkedList<Contributor_Sec22_G15> initialVisited = vertexReachBfs(c1);
        if (initialVisited == null || initialVisited.size() == 1) {
            return false;
        }

        LinkedList<Contributor_Sec22_G15> tempVertices = new LinkedList<>(vertices);
        LinkedList<LinkedList<Collaboration_Sec22_G15>> tempAdjacencyList = new LinkedList<>();
        for (LinkedList<Collaboration_Sec22_G15> list : adjacencyList) {
            tempAdjacencyList.add(new LinkedList<>(list));
        }
        CommunityGraph_Sec22_G15 tempGraph = new CommunityGraph_Sec22_G15(tempVertices, tempAdjacencyList);
        tempGraph.removeEdge(collaboration);

        try {
            if (reachCount(c1) == tempGraph.reachCount(c1)) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + " for contributor " + c1.toString());
            return false;
        }
        return true;
    }
    
    public int numberOfBridges(Contributor_Sec22_G15 contributor) {
        int count = 0;
        int index = vertices.indexOf(contributor);
        if (index == -1) {
            return 0;
        }
        LinkedList<Collaboration_Sec22_G15> edges = adjacencyList.get(index);
        for(Collaboration_Sec22_G15 currentEdge : edges) {
            if(isBridge(currentEdge)) {
                count++;
            }
        }
        return count;
    }

    public void addCluster(Contributor_Sec22_G15 start, String theme) {
        LinkedList<Contributor_Sec22_G15> visited = vertexReachBfs(start);
        try {
            if (visited == null) {
                throw new ContributorHasNoConnections_Sec22_G15(start.toString());
            }
        } catch (ContributorHasNoConnections_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        
        Cluster_Sec22_G15 newCluster = new Cluster_Sec22_G15(theme, visited);
        clusters.add(newCluster);
    }
    
    public LinkedList<String> getProjectIdsForContributor(Contributor_Sec22_G15 contributor) {
        LinkedList<String> projectIds = new LinkedList<>();
        int index = vertices.indexOf(contributor);
        for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
            if(currentEdge.getContributor1().equals(contributor)) {
                projectIds.add(currentEdge.getProjectId());
            }
        }
        return projectIds;
    }
    
        public void ShowClusters() { 
        LinkedList<Contributor_Sec22_G15> InGroup = new LinkedList<>();
        int groupNumber = 1;

        for (Contributor_Sec22_G15 person : vertices) {
            if (!InGroup.contains(person)) {
                LinkedList<Contributor_Sec22_G15> groupMembers = vertexReachBfs(person);
                InGroup.addAll(groupMembers);

                System.out.println("Group " + groupNumber + ":");
                for (Contributor_Sec22_G15 member : groupMembers) {
                    System.out.println(" " + member.toString());
                }
                groupNumber++;
            }
        }
    }
}
