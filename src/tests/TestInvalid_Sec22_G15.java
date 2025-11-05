/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/

import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
import src.edges.Collaboration_Sec22_G15;
import src.vertices.Individual_Sec22_G15;

public class TestInvalid_Sec22_G15 {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        Contributor_Sec22_G15 a = new Individual_Sec22_G15("I1", "Ali", "Writer");
        Contributor_Sec22_G15 b = new Individual_Sec22_G15("I2", "Edwardo", "Artist");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addEdge(new Collaboration_Sec22_G15(a, b, "InvalidProject")); 

        if (graph.getVertices().size() == 1 && graph.getAdjacencyList().size() == 0) {
            System.out.println("Invalid Collaborations pass");
        } else {
            System.out.println("Invalid Collaborations  fail");
        }
    }
}
