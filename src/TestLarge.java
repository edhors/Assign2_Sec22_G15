public class TestLarge {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        graph.addContributor(new Individual_Sec22_G15("I1", "Yousef", "Teacher"));
        graph.addContributor(new Individual_Sec22_G15("I2", "Sara", "Engineer"));
        graph.addContributor(new Individual_Sec22_G15("I3", "Omar", "Doctor"));
        graph.addContributor(new Individual_Sec22_G15("I4", "Lina", "Designer"));
        graph.addContributor(new Individual_Sec22_G15("I5", "Khalid", "Developer"));
        graph.addContributor(new Individual_Sec22_G15("I6", "Maya", "Researcher"));
        graph.addContributor(new Individual_Sec22_G15("I7", "Nadia", "Artist"));
        graph.addContributor(new Individual_Sec22_G15("I8", "Faris", "Scientist"));
        graph.addContributor(new Individual_Sec22_G15("I9", "Rami", "Programmer"));
        graph.addContributor(new Individual_Sec22_G15("I10", "Huda", "Manager"));

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

        if (graph.getContributors().size() == 10 && graph.getCollaborations().size() == 3) {
            System.out.println("Large Dataset  pass");
        } else {
            System.out.println("Large Dataset  fail");
        }
    }
}
