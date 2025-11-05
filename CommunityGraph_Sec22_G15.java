import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//this class is used to represent the community graph
//contributors are the vertices of the graph
//collaborations are the edges of the graph
//clusters are the connected components of the graph
public class CommunityGraph_Sec22_G15 extends AbstractGraph_Sec22_G15<Contributor_Sec22_G15, Collaboration_Sec22_G15> {
    private LinkedList<Cluster_Sec22_G15> clusters;

    public CommunityGraph_Sec22_G15() {
        super(new LinkedList<>(), new LinkedList<>());
        this.clusters = new LinkedList<>();
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices) {
        super(vertices, new LinkedList<>());
        //add an empty list of collaborations to the adjacency list for each contributor
        while (adjacencyList.size() < vertices.size()) {
            adjacencyList.add(new LinkedList<Collaboration_Sec22_G15>());
        }
        this.clusters = new LinkedList<>();
    }

    public CommunityGraph_Sec22_G15(LinkedList<Contributor_Sec22_G15> vertices, LinkedList<LinkedList<Collaboration_Sec22_G15>> adjacencyList) {
        super(vertices, adjacencyList);
        this.clusters = new LinkedList<>();
    }


    public LinkedList<Cluster_Sec22_G15> getClusters() {
        return this.clusters;
    }
    
    //this method is used to add a new contributor to the graph
    @Override
    public void addVertex(Contributor_Sec22_G15 contributor) {
        //check if the contributor already exists
        try {
            for(Contributor_Sec22_G15 c : vertices) {
                //IDs must be unique
                if(c.getId().equals(contributor.getId())) {
                    throw new DuplicateId_Sec22_G15(contributor.getId());
                }
            }
        } catch (DuplicateId_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        //add the contributor to the graph
        vertices.add(contributor);
        //add an empty list of collaborations to the adjacency list
        adjacencyList.add(new LinkedList<>());
    }

    //this method is used to remove a contributor from the graph
    @Override
    public Contributor_Sec22_G15 removeVertex(Contributor_Sec22_G15 contributor) {
        int index = vertices.indexOf(contributor);
        //check if the contributor exists
        try {
            if (index == -1) {
                throw new ContributorNotFound_Sec22_G15(contributor.getName());
            }
        } catch (ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        LinkedList<Collaboration_Sec22_G15> edgesToRemove = new LinkedList<>(adjacencyList.get(index));
        //remove all the collaborations of the contributor
        for(Collaboration_Sec22_G15 currentEdge : edgesToRemove) {
            removeEdge(currentEdge);
        }
        //remove the contributor from the graph
        vertices.remove(index);
        adjacencyList.remove(index);
        return contributor;
    }

    //this method is used to add a new collaboration to the graph
    @Override
    public void addEdge(Collaboration_Sec22_G15 collaboration) {
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        //check if the contributors exist
        Contributor_Sec22_G15 c2 = collaboration.getContributor2();
        String projectId = collaboration.getProjectId();

        //get the index of the contributors in the graph
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

        //create the other collaboration
        Collaboration_Sec22_G15 otherCollaboration = new Collaboration_Sec22_G15(c2, c1, projectId);
    
        adjacencyList.get(index1).add(collaboration);
        adjacencyList.get(index2).add(otherCollaboration);
        //add a new cluster for the contributors
        addCluster(c1, "Cluster Starting from " + c1.getId());
    }
    
    //this method is used to remove a collaboration from the graph
    @Override
    public void removeEdge(Collaboration_Sec22_G15 collaboration) {
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        Contributor_Sec22_G15 c2 = collaboration.getContributor2();
        String projectId = collaboration.getProjectId();

        //get the index of the contributors in the graph
        int index1 = vertices.indexOf(c1);
        int index2 = vertices.indexOf(c2);
    
        //check if the contributors exist
        try {
            if (index1 == -1 || index2 == -1) {
                throw new ContributorNotFound_Sec22_G15(c1.getName() + " or Contributor " + c2.getName());
            }
        } catch (ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }

        //create the other collaboration
        Collaboration_Sec22_G15 otherCollaboration = new Collaboration_Sec22_G15(c2, c1, projectId);
        //check if the collaborations exist
        try {
            if (!adjacencyList.get(index1).contains(collaboration) || !adjacencyList.get(index2).contains(otherCollaboration)) {
                throw new CollaborationNotFound_Sec22_G15(collaboration);
            }
        } catch (CollaborationNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        
        //remove the collaborations from the graph
        adjacencyList.get(index1).remove(collaboration);
        adjacencyList.get(index2).remove(otherCollaboration);
        //add a new cluster for the contributors
        addCluster(c1, "Cluster Starting from " + c1.getId());
        addCluster(c2, "Cluster Starting from " + c2.getId());
    }

    //this method is used to print the graph
    @Override
    public void printGraph() {
        for(Contributor_Sec22_G15 currentVertex : vertices) {
            System.out.print(currentVertex.toString());
            int index = vertices.indexOf(currentVertex);
            for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                System.out.print(" --> " + currentEdge.getContributor2().toString() + " (" + currentEdge.getProjectId() + ")");
            }
            System.out.println();
        }    
    }
    
    //this method is used to get the centrality degree of a contributor
    @Override
    public int centralityDegree(Contributor_Sec22_G15 vertex) {
        int index = vertices.indexOf(vertex);
        if (index == -1){ return 0;}
        return adjacencyList.get(index).size();
    }

    //this method is used to get the reach of a contributor using BFS
    @Override
    public LinkedList<Contributor_Sec22_G15> vertexReachBfs(Contributor_Sec22_G15 start) {
        //check if the contributor exists
        try {
            if (!vertices.contains(start)) {
                throw new ContributorNotFound_Sec22_G15(start.toString());
            }
        } catch(ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
        }
        //initialize the visited list and the queue
        LinkedList<Contributor_Sec22_G15> visited = new LinkedList<>();
        Queue<Contributor_Sec22_G15> queue = new LinkedList<>();
        //add the start contributor to the visited list and the queue
        visited.add(start);
        queue.add(start);
        //while the queue is not empty
        while (!queue.isEmpty()) {
            //get the current contributor from the queue
            //size queue.poll() always returns the first element of the queue, algorithm will always visit the directly connected contributors first (breadth-first search)
            Contributor_Sec22_G15 current = queue.poll();            
            int index = vertices.indexOf(current);
            for (Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                //get the neighbor of the current contributor
                Contributor_Sec22_G15 neighbor = currentEdge.getContributor2();
                if (!visited.contains(neighbor)) {
                    //add the neighbor to the visited list
                    visited.add(neighbor);
                    //add the neighbor to the queue
                    queue.add(neighbor);
                }
            }
        }
        //return the visited list
        return visited;
    }

    //this method is used to get the reach of a contributor using DFS
    @Override
    public LinkedList<Contributor_Sec22_G15> vertexReachDfs(Contributor_Sec22_G15 start) {
        //check if the contributor exists
        try {
            if (!vertices.contains(start)) {
                throw new ContributorNotFound_Sec22_G15(start.toString());
            }
        } catch(ContributorNotFound_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return null;
        }
        //initialize the visited list and the stack
        LinkedList<Contributor_Sec22_G15> visited = new LinkedList<>();
        Stack<Contributor_Sec22_G15> stack = new Stack<>();
        
        //add the start contributor to the visited list and the stack
        visited.add(start);
        stack.add(start);
        
        //while the stack is not empty
        while (!stack.isEmpty()) {
            //get the current contributor from the stack
            //size stack.pop() always returns the last element of the stack, algorithm will always visit the last connected contributor first (depth-first search)
            Contributor_Sec22_G15 current = stack.pop();            
            int index = vertices.indexOf(current);
            for (Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
                //get the neighbor of the current contributor
                Contributor_Sec22_G15 neighbor = currentEdge.getContributor2();
                //if the neighbor is not visited
                if (!visited.contains(neighbor)) {
                    //add the neighbor to the visited list
                    visited.add(neighbor);
                    //add the neighbor to the stack
                    stack.push(neighbor);
                }
            }
        }
        //return the visited list
        return visited;
    }

    //this method is used to get the number of contributors that can be reached from a start contributor
    @Override
    public int reachCount(Contributor_Sec22_G15 start) {
        //get the visited list using BFS
        LinkedList<Contributor_Sec22_G15> visited = vertexReachBfs(start);
        //if the visited list is null, return 0
        if (visited == null) {
            return 0;
        }
        //return the size of the visited list
        return visited.size();
    }   

    //this method is used to check if a collaboration is a bridge
    public boolean isBridge(Collaboration_Sec22_G15 collaboration) {
        //get the first contributor of the collaboration
        Contributor_Sec22_G15 c1 = collaboration.getContributor1();
        //get the visited list using BFS
        LinkedList<Contributor_Sec22_G15> initialVisited = vertexReachBfs(c1);
        //if the visited list is null or has only one element, return false
        if (initialVisited == null || initialVisited.size() == 1) {
            return false;
        }

        //create a temporary graph
        LinkedList<Contributor_Sec22_G15> tempVertices = new LinkedList<>(vertices);
        LinkedList<LinkedList<Collaboration_Sec22_G15>> tempAdjacencyList = new LinkedList<>();
        //add the adjacency list to the temporary graph
        for (LinkedList<Collaboration_Sec22_G15> list : adjacencyList) {
            tempAdjacencyList.add(new LinkedList<>(list));
        }
        //create a temporary graph
        CommunityGraph_Sec22_G15 tempGraph = new CommunityGraph_Sec22_G15(tempVertices, tempAdjacencyList);
        //remove the collaboration from the temporary graph
        tempGraph.removeEdge(collaboration);

        try {
            //if the number of contributors that can be reached from the first contributor is the same as the number of contributors that can be reached from the first contributor in the temporary graph (the graph without the collaboration), then the collaboration is not a bridge
            if (reachCount(c1) == tempGraph.reachCount(c1)) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            //if the index is out of bounds, return false
            System.out.println(e.getMessage() + " for contributor " + c1.toString());
            return false;
        }
        //if the number of contributors that can be reached from the first contributor is not the same as the number of contributors that can be reached from the first contributor in the temporary graph (the graph without the collaboration), then the collaboration is a bridge
        return true;
    }
    
    //this method is used to get the number of bridges in the graph
    public int numberOfBridges(Contributor_Sec22_G15 contributor) {
        //get the index of the contributor in the graph
        int count = 0;
        int index = vertices.indexOf(contributor);
        //if the index is -1, return 0
        if (index == -1) {
            return 0;
        }
        //get the edges of the contributor
        LinkedList<Collaboration_Sec22_G15> edges = adjacencyList.get(index);
        for(Collaboration_Sec22_G15 currentEdge : edges) {
            //if the collaboration is a bridge, increment the count
            if(isBridge(currentEdge)) {
                count++;
            }
        }
        //return the count
        return count;
    }

    //this method is used to add a new cluster to the graph
    public void addCluster(Contributor_Sec22_G15 start, String theme) {
        //get the visited list using BFS
        LinkedList<Contributor_Sec22_G15> visited = vertexReachBfs(start);
        try {
            //if the visited list has only one element, throw an exception
            if (visited.size() <= 1) {
                throw new ContributorHasNoConnections_Sec22_G15(start.toString());
            }
        } catch (ContributorHasNoConnections_Sec22_G15 e) {
            //if the contributor has no connections, remove the cluster
            for(Cluster_Sec22_G15 currentCluster : clusters) {
                if(currentCluster.getContributors().contains(start)) {
                    System.out.println("Removing cluster: " + currentCluster.getTheme());
                    removeCluster(currentCluster);
                }
            }
            System.out.println(e.getMessage());
            return;
        }
        //create a new cluster
        Cluster_Sec22_G15 newCluster = new Cluster_Sec22_G15(theme, visited);
        //create a list of clusters to remove
        //this is necessary to avoid concurrent modification exception
        LinkedList<Cluster_Sec22_G15> clustersToRemove = new LinkedList<>();
        //for each cluster
        for(Cluster_Sec22_G15 currentCluster : clusters) {
            //for each contributor in the cluster
            for(Contributor_Sec22_G15 currentContributor : currentCluster.getContributors()) {
                if(visited.contains(currentContributor)) {
                    //if the cluster theme does not contain "Starting from" (the default theme of the cluster), set the new cluster theme to the current cluster theme
                    if(!currentCluster.getTheme().contains("Starting from")) {
                        newCluster.setTheme(currentCluster.getTheme());
                    }
                    //add the cluster to the list of clusters to remove
                    clustersToRemove.add(currentCluster);
                    break;
                }
            }
        }
        //for each cluster in the list of clusters to remove
        for(Cluster_Sec22_G15 cluster : clustersToRemove) {
            removeCluster(cluster);
        }
        //add the new cluster to the graph
        clusters.add(newCluster);
    }

    //this method is used to remove a cluster from the graph
    public void removeCluster(Cluster_Sec22_G15 cluster) {
        //remove the cluster from the graph
        clusters.remove(cluster);
    }
    //this method is used to get the project ids for a contributor
    public LinkedList<String> getProjectIdsForContributor(Contributor_Sec22_G15 contributor) {
        //get the index of the contributor in the graph
        LinkedList<String> projectIds = new LinkedList<>();
        int index = vertices.indexOf(contributor);
        //for each collaboration of the contributor
        for(Collaboration_Sec22_G15 currentEdge : adjacencyList.get(index)) {
            //if the contributor is the first contributor of the collaboration, add the project id to the list
            if(currentEdge.getContributor1().equals(contributor)) {
                projectIds.add(currentEdge.getProjectId());
            }
        }
        //return the list of project ids
        return projectIds;
    }
    
    //this method is used to rank the contributors by centrality degree
    public void contributorsRankingByCentralityDegree() {
        //get the list of contributors
        LinkedList<Contributor_Sec22_G15> contributors = new LinkedList<>(vertices);
        Collections.sort(contributors, new CentralityDegreeComparator_Sec22_G15(this));
        System.out.println("Contributors ranking by centrality degree:");
        //print the contributors
        for(Contributor_Sec22_G15 currentContributor : contributors) {
            System.out.println(currentContributor.toString() + " - " + centralityDegree(currentContributor));
        }
    }
    //this method is used to rank the contributors by number of bridges
    public void contributorsRankingByNumberOfBridges() {
        //get the list of contributors
        LinkedList<Contributor_Sec22_G15> contributors = new LinkedList<>(vertices);
        Collections.sort(contributors, new NumberOfBridgesComparator_Sec22_G15(this));
        System.out.println("Contributors ranking by number of bridges:");
        //print the contributors
        for(Contributor_Sec22_G15 currentContributor : contributors) {
            System.out.println(currentContributor.toString() + " - " + numberOfBridges(currentContributor));
        }
    }

    //this method is used to display the clusters
    public void displayClusters() {
        //print the clusters
        System.out.println("Clusters:");
        int index = 1;
        //for each cluster
        for(Cluster_Sec22_G15 currentCluster : clusters) {
            System.out.print(index + ". " + currentCluster.getTheme() + ":");
            for(Contributor_Sec22_G15 currentContributor : currentCluster.getContributors()) {
                System.out.print(" " + currentContributor.toString());
            }
            System.out.println();
            index++;
        }
    }
}
