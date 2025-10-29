import java.util.LinkedList;
public class Cluster_Sec22_G15 extends Project_Sec22_G15 {
    private String projectId;
    private LinkedList<Contributor_Sec22_G15> contributors;

    public Cluster_Sec22_G15(String projectId) {
        super(projectId);
        this.contributors = new LinkedList<>();
    }

    
}
