/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.clusters;
import java.util.LinkedList;

import src.vertices.Contributor_Sec22_G15;
//this class is used to represent the cluster
//contributors are the vertices of the cluster
//theme is the theme of the cluster
public class Cluster_Sec22_G15 {
    private LinkedList<Contributor_Sec22_G15> contributors;
    private String theme;

    public Cluster_Sec22_G15(String theme) {
        this.theme = theme;
        this.contributors = new LinkedList<>();
    }

    public Cluster_Sec22_G15(LinkedList<Contributor_Sec22_G15> contributors) {
        this.theme = contributors.get(0).getName();
        this.contributors = contributors;
    }


    public Cluster_Sec22_G15(String theme, LinkedList<Contributor_Sec22_G15> contributors) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cluster_Sec22_G15))
            return false;
        Cluster_Sec22_G15 other = (Cluster_Sec22_G15)o;
        return this.contributors.containsAll(other.contributors) && other.contributors.containsAll(this.contributors);
    }
}
