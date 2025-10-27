public class Collaboration_Sec22_G15 {
    private Contributor_Sec22_G15 contributor1;
    private Contributor_Sec22_G15 contributor2;
    private String projectId;

    public Collaboration_Sec22_G15(Contributor_Sec22_G15 contributor1, Contributor_Sec22_G15 contributor2, String projectId) {
        this.contributor1 = contributor1;
        this.contributor2 = contributor2;
        this.projectId = projectId;
    }

    public Contributor_Sec22_G15 getContributor1() {
        return this.contributor1;
    }

    public Contributor_Sec22_G15 getContributor2() {
        return this.contributor2;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setContributor1(Contributor_Sec22_G15 contributor1) {
        this.contributor1 = contributor1;
    }

    public void setContributor2(Contributor_Sec22_G15 contributor2) {
        this.contributor2 = contributor2;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
