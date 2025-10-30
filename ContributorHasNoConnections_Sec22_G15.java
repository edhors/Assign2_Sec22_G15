public class ContributorHasNoConnections_Sec22_G15 extends Exception {
    public ContributorHasNoConnections_Sec22_G15(String contributorName) {
        super("Contributor " + contributorName + " has no connections");
    }
}
