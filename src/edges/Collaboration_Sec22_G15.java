/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/
package src.edges;

import src.vertices.Contributor_Sec22_G15;

//this class is used to represent the collaboration
//a collaboration is an edge between two contributors
//projectId is the id of the project
//contributor1 is the first contributor of the collaboration
//contributor2 is the second contributor of the collaboration
public class Collaboration_Sec22_G15 {
    private String projectId;
    private Contributor_Sec22_G15 contributor1;
    private Contributor_Sec22_G15 contributor2;

    public Collaboration_Sec22_G15(Contributor_Sec22_G15 contributor1, Contributor_Sec22_G15 contributor2, String projectId) {
        this.projectId = projectId;
        this.contributor1 = contributor1;
        this.contributor2 = contributor2;
    }

    public String getProjectId() {
        return projectId;
    }

    public Contributor_Sec22_G15 getContributor1() {
        return contributor1;
    }

    public Contributor_Sec22_G15 getContributor2() {
        return contributor2;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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
