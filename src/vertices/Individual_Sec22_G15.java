/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.vertices;
//this class is used to represent the individual
//occupation is the occupation of the individual
public class Individual_Sec22_G15 extends Contributor_Sec22_G15 {
    private String occupation;
    public Individual_Sec22_G15(String id, String name, String occupation) {
        super(id, name);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
