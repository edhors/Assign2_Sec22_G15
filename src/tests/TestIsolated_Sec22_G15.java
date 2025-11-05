package src;

import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
import src.vertices.Individual_Sec22_G15;
import src.vertices.Organization_Sec22_G15;
public class TestIsolated_Sec22_G15 {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        Contributor_Sec22_G15 c1 = new Individual_Sec22_G15("I1", "Edwardo", "Doctor");
        Contributor_Sec22_G15 c2 = new Individual_Sec22_G15("I2", "Ali", "Teacher");
        Contributor_Sec22_G15 c3 = new Organization_Sec22_G15("O1", "School");

        graph.addVertex(c1);
        graph.addVertex(c2);
        graph.addVertex(c3);

        if (graph.getAdjacencyList().size() == 0 && graph.getVertices().size() == 3) {
            System.out.println("TestIsolatedContributors passed!");
        } else {
            System.out.println("TestIsolatedContributors failed!");
        }
    }
}
