import java.util.LinkedList;
public class Cluster_Sec22_G15 extends Project_Sec22_G15 {
    private LinkedList<Contributor_Sec22_G15> contributors;
    private String theme;

    public Cluster_Sec22_G15(String projectId, String theme) {
        super(projectId);
        this.theme = theme;
        this.contributors = new LinkedList<>();
    }

    public Cluster_Sec22_G15(String projectId, String theme, LinkedList<Contributor_Sec22_G15> contributors) {
        super(projectId);
        this.theme = theme;
        this.contributors = contributors;
    }

    public void addContributor(Contributor_Sec22_G15 contributor) {
        this.contributors.add(contributor);
    }

    public void removeContributor(Contributor_Sec22_G15 contributor) {
        this.contributors.remove(contributor);
    }

    public LinkedList<Contributor_Sec22_G15> getContributors() {
        return this.contributors;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
