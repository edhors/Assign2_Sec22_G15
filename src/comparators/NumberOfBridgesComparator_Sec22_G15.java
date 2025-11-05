/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/
package src.comparators;
import java.util.Comparator;

import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
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
