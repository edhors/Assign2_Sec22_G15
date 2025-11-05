package src;

import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
import src.edges.Collaboration_Sec22_G15;
import src.vertices.Individual_Sec22_G15;

public class TestDuplicate_Sec22_G15 {
public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        Contributor_Sec22_G15 a = new Individual_Sec22_G15("I1", "Ali", "Engineer");
        Contributor_Sec22_G15 b = new Individual_Sec22_G15("I2", "Edwardo", "Doctor");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(b); 

        graph.addEdge(new Collaboration_Sec22_G15(a, b, "Project1"));
        graph.addEdge(new Collaboration_Sec22_G15(a, b, "Project1")); 

        if (graph.getVertices().size() == 2 && graph.getAdjacencyList().size() == 1) {
            System.out.println("Duplicate Entries ");
        } else {
            System.out.println( "No Duplicate Entries ");
        }
    }
}

