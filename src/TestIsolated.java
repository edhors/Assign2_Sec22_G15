public class TestIsolated {
    public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        Contributor_Sec22_G15 c1 = new Individual_Sec22_G15("I1", "Edwardo", "Doctor");
        Contributor_Sec22_G15 c2 = new Individual_Sec22_G15("I2", "Ali", "Teacher");
        Contributor_Sec22_G15 c3 = new Organization_Sec22_G15("O1", "School", "Education");

        graph.addContributor(c1);
        graph.addContributor(c2);
        graph.addContributor(c3);

        if (graph.getCollaborations().size() == 0 && graph.getContributors().size() == 3) {
            System.out.println("TestIsolatedContributors passed!");
        } else {
            System.out.println("TestIsolatedContributors failed!");
        }
    }
}
