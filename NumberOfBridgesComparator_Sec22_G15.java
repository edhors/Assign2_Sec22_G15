import java.util.Comparator;
//this class is used to compare the number of bridges of two contributors
public class NumberOfBridgesComparator_Sec22_G15 implements Comparator<Contributor_Sec22_G15> {
    private CommunityGraph_Sec22_G15 graph;
    public NumberOfBridgesComparator_Sec22_G15(CommunityGraph_Sec22_G15 graph) {
        this.graph = graph;
    }
    @Override
    public int compare(Contributor_Sec22_G15 o1, Contributor_Sec22_G15 o2) {
        if(graph.numberOfBridges(o1) > graph.numberOfBridges(o2)) return -1;
        if(graph.numberOfBridges(o1) < graph.numberOfBridges(o2)) return 1;
        return 0;
    }
}
