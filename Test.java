import java.util.ArrayList;
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

        Individual_Sec22_G15[] array = {i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};

        LinkedList<Contributor_Sec22_G15> individuals = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
            individuals.add(array[i]);
        }

        CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15(individuals);

        graph.addEdge(i1, i2, "Project 1");
        graph.addEdge(i2, i5, "Project 2");
        graph.addEdge(i3, i7, "Project 3");
        graph.addEdge(i3, i9, "Project 4");
        graph.addEdge(i5, i1, "Project 5");
        graph.addEdge(i6, i2, "Project 6");
        graph.addEdge(i7, i10, "Project 7");
        graph.addEdge(i8, i4, "Project 8");
        graph.addEdge(i9, i6, "Project 9");
        graph.addEdge(i10, i9, "Project 10");

        Individual_Sec22_G15 outsider = new Individual_Sec22_G15("I11", "Outsider", "Software Engineer");
        graph.removeVertex(outsider);
        System.out.println("Graph: ");
        //graph.printGraph();
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString() + "\n   Neighbors Count: " + graph.neighborsCount(array[i]) + "\n   Reach Count: " + graph.reachCount(array[i]));
        }
    }
}
