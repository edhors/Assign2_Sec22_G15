import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Individual_Sec22_G15 i1 = new Individual_Sec22_G15("I1", "John Doe", "Software Engineer");
        Individual_Sec22_G15 i2 = new Individual_Sec22_G15("I2", "Jane Smith", "Software Engineer");
        Individual_Sec22_G15 i3 = new Individual_Sec22_G15("I3", "Jim Johnson", "Software Engineer");
        Individual_Sec22_G15 i4 = new Individual_Sec22_G15("I4", "Jill Williams", "Software Engineer");
        Individual_Sec22_G15 i5 = new Individual_Sec22_G15("I5", "Jack Brown", "Software Engineer");
        Individual_Sec22_G15 i6 = new Individual_Sec22_G15("I6", "Josh Brown", "Software Engineer");
        Individual_Sec22_G15 i7 = new Individual_Sec22_G15("I7", "James Johnson", "Software Engineer");
        Individual_Sec22_G15 i8 = new Individual_Sec22_G15("I8", "Jessica Miller", "Software Engineer");
        Individual_Sec22_G15 i9 = new Individual_Sec22_G15("I9", "Jacob Wilson", "Software Engineer");
        Individual_Sec22_G15 i10 = new Individual_Sec22_G15("I10", "Jasmine Lee", "Software Engineer");

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

        Individual_Sec22_G15 outsider = new Individual_Sec22_G15("I11", "Outsider", "Software Engineer");
        graph.removeVertex(outsider);
        System.out.println("Graph: ");
        graph.printGraph();
        System.out.println(i1.toString() + " influence: " + graph.influence(i1));
        //graph.bfs(i1);
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
