/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/
package src.vertices;
//this class is used to represent the contributor
//a contributor is a vertex in the graph
//id is the id of the contributor
//name is the name of the contributor
public class Contributor_Sec22_G15 {
    private String id;
    private String name;

    public Contributor_Sec22_G15(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " ID: " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contributor_Sec22_G15))
            return false;
        Contributor_Sec22_G15 other = (Contributor_Sec22_G15)o;
        
        return this.id.equals(other.id) && this.name.equals(other.name);
    }
}
