public class ContributorNotFound_Sec22_G15 extends Exception {
    public ContributorNotFound_Sec22_G15(String contributorName) {
        super("Contributor " + contributorName + " not found!");
    }
}
