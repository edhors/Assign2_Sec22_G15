public class TestLarge {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();
        graph.addContributor(new Individual_Sec22_G15("I1", "Yousef", "Teacher"));
        graph.addContributor(new Individual_Sec22_G15("I2", "Sara", "Engineer"));
        graph.addContributor(new Individual_Sec22_G15("I3", "Omar", "Doctor"));
        graph.addContributor(new Individual_Sec22_G15("I4", "Lina", "Designer"));
        graph.addContributor(new Individual_Sec22_G15("I5", "Khalid", "Developer"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I1", "Yousef", "Teacher"),
                new Individual_Sec22_G15("I2", "Sara", "Engineer"),
                "Project1"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I3", "Omar", "Doctor"),
                new Individual_Sec22_G15("I4", "Lina", "Designer"),
                "Project2"));

        graph.addEdge(new Collaboration_Sec22_G15(
                new Individual_Sec22_G15("I5", "Khalid", "Developer"),
                new Individual_Sec22_G15("I1", "Yousef", "Teacher"),
                "Project3"));

        System.out.println(" Large Dataset Test ");
        graph.printGraph();
    }
}
