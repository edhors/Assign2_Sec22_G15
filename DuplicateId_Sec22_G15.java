public class DuplicateId_Sec22_G15 extends Exception {
    public DuplicateId_Sec22_G15(String id) {
        super("ID already exists: " + id);
    }
}
