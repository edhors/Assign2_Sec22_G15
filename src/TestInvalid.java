public class TestInvalid {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();
        Contributor_Sec22_G15 a = new Individual_Sec22_G15("I1", "Ali", "Writer");
        Contributor_Sec22_G15 b = new Individual_Sec22_G15("I2", "Edwardo", "Artist");
        graph.addContributor(a);
        graph.addEdge(new Collaboration_Sec22_G15(a, b, "InvalidProject"));
        System.out.println("Invalid Collaborations Test");
        graph.displayContributors();
        graph.displayCollaborations(); 
    }
}
