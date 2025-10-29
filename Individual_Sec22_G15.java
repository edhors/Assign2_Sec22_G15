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
