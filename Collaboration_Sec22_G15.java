import java.util.Objects;

public class Collaboration_Sec22_G15 extends Project_Sec22_G15 {
    private Contributor_Sec22_G15 contributor1;
    private Contributor_Sec22_G15 contributor2;

    public Collaboration_Sec22_G15(Contributor_Sec22_G15 contributor1, Contributor_Sec22_G15 contributor2, String projectId) {
        super(projectId);
        this.contributor1 = contributor1;
        this.contributor2 = contributor2;
    }

    public Contributor_Sec22_G15 getContributor1() {
        return contributor1;
    }

    public Contributor_Sec22_G15 getContributor2() {
        return contributor2;
    }

    public void setContributor1(Contributor_Sec22_G15 contributor1) {
        this.contributor1 = contributor1;
    }

    public void setContributor2(Contributor_Sec22_G15 contributor2) {
        this.contributor2 = contributor2;
    }

    public String toString() {
        return "Collaboration between " + contributor1.toString() + " and " + contributor2.toString() + " on project " + getProjectId();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Collaboration_Sec22_G15))
            return false;
        Collaboration_Sec22_G15 other = (Collaboration_Sec22_G15)o;
        return this.contributor1.equals(other.contributor1) && this.contributor2.equals(other.contributor2) && this.getProjectId().equals(other.getProjectId());
    }

}
