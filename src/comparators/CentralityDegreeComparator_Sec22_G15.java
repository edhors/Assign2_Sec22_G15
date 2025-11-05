/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.comparators;
import java.util.Comparator;

import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
//this class is used to compare the centrality degree of two contributors
public class CentralityDegreeComparator_Sec22_G15 implements Comparator<Contributor_Sec22_G15> {
    private CommunityGraph_Sec22_G15 graph;
    public CentralityDegreeComparator_Sec22_G15(CommunityGraph_Sec22_G15 graph) {
        this.graph = graph;
    }
    //this method is used to compare the centrality degree of two contributors
    @Override
    public int compare(Contributor_Sec22_G15 o1, Contributor_Sec22_G15 o2) {
        if(graph.centralityDegree(o1) > graph.centralityDegree(o2)) return -1;
        if(graph.centralityDegree(o1) < graph.centralityDegree(o2)) return 1;
        return 0;
    }
}
