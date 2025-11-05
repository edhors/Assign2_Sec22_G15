public class TestDuplicate {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        Contributor_Sec22_G15 a = new Individual_Sec22_G15("I1", "Ali", "Engineer");
        Contributor_Sec22_G15 b = new Individual_Sec22_G15("I2", "Edwardo", "Designer");

        graph.addContributor(a);
        graph.addContributor(a); 
        graph.addContributor(b);

        graph.addEdge(new Collaboration_Sec22_G15(a, b, "Project1"));
        graph.addEdge(new Collaboration_Sec22_G15(a, b, "Project1")); 

        System.out.println("Duplicate Entries Test ");
        graph.displayContributors();
        graph.displayCollaborations();
    }
}

