/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/

import src.graphs.CommunityGraph_Sec22_G15;
import src.edges.Collaboration_Sec22_G15;
import src.vertices.Individual_Sec22_G15;

public class TestLarge_Sec22_G15 {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        graph.addVertex(new Individual_Sec22_G15("I1", "Yousef", "Teacher"));
        graph.addVertex(new Individual_Sec22_G15("I2", "Sara", "Engineer"));
        graph.addVertex(new Individual_Sec22_G15("I3", "Omar", "Doctor"));
        graph.addVertex(new Individual_Sec22_G15("I4", "Lina", "Designer"));
        graph.addVertex(new Individual_Sec22_G15("I5", "Khalid", "Developer"));
        graph.addVertex(new Individual_Sec22_G15("I6", "Maya", "Researcher"));
        graph.addVertex(new Individual_Sec22_G15("I7", "Nadia", "Artist"));
        graph.addVertex(new Individual_Sec22_G15("I8", "Faris", "Scientist"));
        graph.addVertex(new Individual_Sec22_G15("I9", "Rami", "Programmer"));
        graph.addVertex(new Individual_Sec22_G15("I10", "Huda", "Manager"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I1", "Yousef", "Teacher"),
                new Individual_Sec22_G15("I2", "Sara", "Engineer"),
                "Project Alpha"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I3", "Omar", "Doctor"),
                new Individual_Sec22_G15("I4", "Lina", "Designer"),
                "Project Beta"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I5", "Khalid", "Developer"),
                new Individual_Sec22_G15("I1", "Yousef", "Teacher"),
                "Project Gamma"));

        if (graph.getVertices().size() == 10 && graph.getAdjacencyList().size() == 3) {
            System.out.println("Large Dataset  pass");
        } else {
            System.out.println("Large Dataset  fail");
        }
    }
}
