import java.util.LinkedList;

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
