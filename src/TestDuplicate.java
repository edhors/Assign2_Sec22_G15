public class TestDuplicate {
public static void main(String[] args) {
        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();

        graph.addVertex(new Individual_Sec22_G15("I1", "Edwardo", "Doctor"));
        graph.addVertex(new Individual_Sec22_G15("I2", "Ali", "Teacher"));
        graph.addVertex(new Organization_Sec22_G15("O1", "adu", "Education"));

       
        if (graph.getEdges().isEmpty()) {
            System.out.println("Isolated Contributors  pass");
        } else {
            System.out.println("Isolated Contributors  fail");
        }
    }
}

