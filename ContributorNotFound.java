public class ContributorNotFound extends Exception {
    public ContributorNotFound(String contributorName) {
        super("Contributor " + contributorName + " not found!");
    }
}
