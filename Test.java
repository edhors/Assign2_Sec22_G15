import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Individual_Sec22_G15 i1 = new Individual_Sec22_G15("1", "John Doe");
        Individual_Sec22_G15 i2 = new Individual_Sec22_G15("2", "Jane Smith");
        Individual_Sec22_G15 i3 = new Individual_Sec22_G15("3", "Jim Johnson");
        Individual_Sec22_G15 i4 = new Individual_Sec22_G15("4", "Jill Williams");
        Individual_Sec22_G15 i5 = new Individual_Sec22_G15("5", "Jack Brown");
        Individual_Sec22_G15 i6 = new Individual_Sec22_G15("6", "Josh Brown");
        Individual_Sec22_G15 i7 = new Individual_Sec22_G15("7", "James Johnson");
        Individual_Sec22_G15 i8 = new Individual_Sec22_G15("8", "Jessica Miller");
        Individual_Sec22_G15 i9 = new Individual_Sec22_G15("9", "Jacob Wilson");
        Individual_Sec22_G15 i10 = new Individual_Sec22_G15("10", "Jasmine Lee");

        LinkedList<Contributor_Sec22_G15> individuals = new LinkedList<>();
        individuals.add(i1);
        individuals.add(i2);
        individuals.add(i3);
        individuals.add(i4);
        individuals.add(i5);
        individuals.add(i6);
        individuals.add(i7);
        individuals.add(i8);
        individuals.add(i9);
        individuals.add(i10);

        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15(individuals);

        graph.addEdge(i1, i2, "Project 1");
        graph.addEdge(i2, i3, "Project 2");
        graph.addEdge(i3, i4, "Project 3");
        graph.addEdge(i4, i5, "Project 4");
        graph.addEdge(i5, i6, "Project 5");
        graph.addEdge(i6, i7, "Project 6");
        graph.addEdge(i7, i8, "Project 7");
        graph.addEdge(i8, i9, "Project 8");
        graph.addEdge(i9, i10, "Project 9");
        graph.addEdge(i10, i1, "Project 10");


        graph.removeVertex(i1);
        System.out.println("Graph: ");
        graph.printGraph();
    }
}

/*
John Doe -> Jane Smith (Project 1) -> Jasmine Lee (Project 10)
Jane Smith -> John Doe (Project 1) -> Jim Johnson (Project 2)
Jim Johnson -> Jane Smith (Project 2) -> Jill Williams (Project 3)
Jill Williams -> Jim Johnson (Project 3) -> Jack Brown (Project 4)
Jack Brown -> Jill Williams (Project 4) -> Josh Brown (Project 5)
Josh Brown -> Jack Brown (Project 5) -> James Johnson (Project 6)
James Johnson -> Josh Brown (Project 6) -> Jessica Miller (Project 7)
Jessica Miller -> James Johnson (Project 7) -> Jacob Wilson (Project 8)
Jacob Wilson -> Jessica Miller (Project 8) -> Jasmine Lee (Project 9)
Jasmine Lee -> Jacob Wilson (Project 9) -> John Doe (Project 10)
 */
