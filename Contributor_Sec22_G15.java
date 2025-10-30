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
