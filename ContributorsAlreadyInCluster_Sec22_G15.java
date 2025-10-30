public class ContributorsAlreadyInCluster_Sec22_G15 extends Exception {
    public ContributorsAlreadyInCluster_Sec22_G15(Contributor_Sec22_G15 start) {
        super("Contributors within reach of " + start.toString() + " already in a cluster");
    }
}
