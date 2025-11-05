/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src.vertices;
import java.util.LinkedList;
//this class is used to represent the organization
//members are the contributors of the organization
//members are not necessarily contributors of the graph
public class Organization_Sec22_G15 extends Contributor_Sec22_G15{
    private LinkedList<Contributor_Sec22_G15> members;
    public Organization_Sec22_G15(String id, String name) {
        super(id, name);
        this.members = new LinkedList<>();
    }

    public void addMember(Contributor_Sec22_G15 member) {
        this.members.add(member);
    }

    public void removeMember(Contributor_Sec22_G15 member) {
        this.members.remove(member);
    }

    public LinkedList<Contributor_Sec22_G15> getMembers() {
        return this.members;
    }
}
