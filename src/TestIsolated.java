public class TestIsolated {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        graph.addContributor(new Individual_Sec22_G15("I1", "Edwardo", "Doctor"));
        graph.addContributor(new Individual_Sec22_G15("I2", "Ali", "Doctor"));
        graph.addContributor(new Organization_Sec22_G15("1", "School", "Education"));

        
        System.out.println("Isolated Contributors Test");
        graph.displayContributors();
        graph.displayCollaborations(); 
    }
}
