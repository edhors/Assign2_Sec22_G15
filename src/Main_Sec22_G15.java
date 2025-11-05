/*
csc301 Section 22 Assignment 2 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package src;
import java.util.LinkedList;
import java.util.Scanner;

import src.edges.Collaboration_Sec22_G15;
import src.graphs.CommunityGraph_Sec22_G15;
import src.vertices.Contributor_Sec22_G15;
import src.vertices.Individual_Sec22_G15;
import src.vertices.Organization_Sec22_G15;
public class Main_Sec22_G15 {
    public static void main(String[] args) {
        System.out.println("Welcome to the Community Graph!");
        initializeGraph();
        int choice = -1;
        while (choice != 0) {
            try {
                menu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addContributor();
                        break;
                    case 2:
                        removeContributor();
                        break;
                    case 3:
                        addCollaboration();
                        break;
                    case 4:
                        removeCollaboration();
                        break;
                    case 5:
                        displayClusters();
                        break;
                    case 6:
                        updateClusterTheme();
                        break;
                    case 7:
                        contributorsRankingByCentralityDegree();
                        break;
                    case 8:
                        contributorsRankingByNumberOfBridges();
                        break;
                    case 9:
                        printGraph();
                        break;
                    case 0:
                        System.out.println("Thank you for using the Community Graph!");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
    private static Scanner scanner = new Scanner(System.in);

    private static CommunityGraph_Sec22_G15 graph = new CommunityGraph_Sec22_G15();
    
    public static void menu() {
        System.out.println("1. Add a new contributor");
        System.out.println("2. Remove a contributor");
        System.out.println("3. Add a new collaboration");
        System.out.println("4. Remove a collaboration");
        System.out.println("5. Display clusters");
        System.out.println("6. Update cluster theme");
        System.out.println("7. Contributors ranking by centrality degree");
        System.out.println("8. Contributors ranking by number of bridges");
        System.out.println("9. Print the graph");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }


    //1. Add a new contributor
    public static void addContributor() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter the type of the contributor: ");
                System.out.println("1. Individual");
                System.out.println("2. Organization");
                int type = scanner.nextInt();
                if (type != 1 && type != 2) {
                    throw new Exception("Invalid type");
                }
                scanner.nextLine();
                System.out.print("Enter the id of the contributor: ");
                String id = scanner.nextLine();
                System.out.print("Enter the name of the contributor: ");
                String name = scanner.nextLine();
                String occupation = "";
                if(type == 1) {
                    System.out.print("Enter the occupation of the contributor: ");
                    occupation = scanner.nextLine();
                }
                switch (type) {
                    case 1:
                        graph.addVertex(new Individual_Sec22_G15(id, name, occupation));
                        System.out.println("Contributor added successfully");
                        break;
                    case 2:
                        graph.addVertex(new Organization_Sec22_G15(id, name));
                        System.out.println("Contributor added successfully");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to add another contributor? (1. Yes, 0. No)");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    //2. Remove a contributor
    public static void removeContributor() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter the type of the contributor: ");
                System.out.println("1. Individual");
                System.out.println("2. Organization");
                int type = scanner.nextInt();
                if (type != 1 && type != 2) {
                    throw new Exception("Invalid type");
                }
                scanner.nextLine();
                System.out.print("Enter the id of the contributor: ");
                String id = scanner.nextLine();
                System.out.print("Enter the name of the contributor: ");
                String name = scanner.nextLine();
                String occupation = "";
                if(type == 1) {
                    System.out.print("Enter the occupation of the contributor: ");
                    occupation = scanner.nextLine();
                }
                switch (type) {
                    case 1:
                        graph.removeVertex(new Individual_Sec22_G15(id, name, occupation));
                        System.out.println("Contributor removed successfully");
                        break;
                    case 2:
                        graph.removeVertex(new Organization_Sec22_G15(id, name));
                        System.out.println("Contributor removed successfully");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to remove another contributor? (1. Yes, 0. No)");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }
    
    //3. Add a new collaboration
    public static void addCollaboration() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            Contributor_Sec22_G15 contributor1 = null;
            Contributor_Sec22_G15 contributor2 = null;
            for(int i = 1; i <= 2; i++) {
                try {
                    System.out.println("Enter the type of the contributor " + i + ": ");
                    System.out.println("1. Individual");
                    System.out.println("2. Organization");
                    int type = scanner.nextInt();
                    if (type != 1 && type != 2) {
                        throw new Exception("Invalid type");
                    }
                    scanner.nextLine();
                    System.out.print("Enter the id of the contributor " + i + ": ");
                    String id = scanner.nextLine();
                    System.out.print("Enter the name of the contributor " + i + ": ");
                    String name = scanner.nextLine();
                    String occupation = "";
                    if(type == 1) {
                        System.out.print("Enter the occupation of the contributor " + i + ": ");
                        occupation = scanner.nextLine();
                    }
                    if(i == 1) {
                        switch (type) {
                            case 1:
                                contributor1 = new Individual_Sec22_G15(id, name, occupation);
                                break;
                            case 2:
                                contributor1 = new Organization_Sec22_G15(id, name);
                                break;
                        }
                    } else {
                        switch (type) {
                            case 1:
                                contributor2 = new Individual_Sec22_G15(id, name, occupation);
                                break;
                            case 2:
                                contributor2 = new Organization_Sec22_G15(id, name);
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            if(contributor1 != null && contributor2 != null) {
                graph.addEdge(new Collaboration_Sec22_G15(contributor1, contributor2, "Project " + (graph.getVertices().size() + 1)));
                System.out.println("Collaboration added successfully");
            }
            System.out.println("Do you want to add another collaboration? (1. Yes, 0. No)");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    //4. Remove a collaboration
    public static void removeCollaboration() {
        System.out.println("--------------------------------");
    int choice = 1;
    while (choice != 0) {
        scanner.nextLine();
        try {
            System.out.print("Enter first contributor ID: ");
            String id1 = scanner.nextLine();
            System.out.print("Enter second contributor ID: ");
            String id2 = scanner.nextLine();

            Contributor_Sec22_G15 contributor1 = null;
            Contributor_Sec22_G15 contributor2 = null;

            for (Contributor_Sec22_G15 c : graph.getVertices()) {
                if (c.getId().equals(id1)) contributor1 = c;
                if (c.getId().equals(id2)) contributor2 = c;
            }

            if (contributor1 == null || contributor2 == null) {
                System.out.println("contributor not found in the graph");
            } else {
                System.out.print("Enter project ID: ");
                String projectID = scanner.nextLine();
                graph.removeEdge(new Collaboration_Sec22_G15(contributor1, contributor2, projectID));
                System.out.println("Collaboration removed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Do you want to remove another collaboration? (1. Yes, 0. No)");
        choice = scanner.nextInt();
        try {
            if (choice != 1 && choice != 0) {
                throw new Exception("Invalid input");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        System.out.println("--------------------------------");
    }
    //5. Display clusters
    public static void displayClusters() {
        System.out.println("--------------------------------");
        graph.displayClusters();
        System.out.println("--------------------------------");
    }

    //6. Update cluster theme
    public static void updateClusterTheme() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                displayClusters();
                System.out.print("Enter the index of the cluster to update: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.print("Enter the new theme: ");
                String theme = scanner.nextLine();
                graph.getClusters().get(index).setTheme(theme);
                System.out.println("Cluster updated successfully");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to update another cluster theme? (1. Yes, 0. No)");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    //7. Contributors ranking by centrality degree
    public static void contributorsRankingByCentralityDegree() {
        System.out.println("--------------------------------");
        graph.contributorsRankingByCentralityDegree();
        System.out.println("Press any key to go back to the menu");
        scanner.nextLine();
        System.out.println("--------------------------------");
    }

    //8. Contributors ranking by number of bridges
    public static void contributorsRankingByNumberOfBridges() {
        System.out.println("--------------------------------");
        graph.contributorsRankingByNumberOfBridges();
        System.out.println("Press any key to go back to the menu");
        scanner.nextLine();
        System.out.println("--------------------------------");
    }

    //9. Print the graph
    public static void printGraph() {
        System.out.println("--------------------------------");
        graph.printGraph();
        System.out.println("Press any key to go back to the menu");
        scanner.nextLine();
        System.out.println("--------------------------------");
    }
    
    public static void initializeGraph() {
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
        Individual_Sec22_G15 i11 = new Individual_Sec22_G15("I11", "Outsider", "Software Engineer");

        Individual_Sec22_G15[] array = {i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11};

        LinkedList<Contributor_Sec22_G15> individuals = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
            individuals.add(array[i]);
        }

        graph = new CommunityGraph_Sec22_G15(individuals);

        graph.addEdge(new Collaboration_Sec22_G15(i1, i2, "Project 1"));
        graph.addEdge(new Collaboration_Sec22_G15(i2, i5, "Project 2"));
        graph.addEdge(new Collaboration_Sec22_G15(i3, i7, "Project 3"));
        graph.addEdge(new Collaboration_Sec22_G15(i3, i9, "Project 4"));
        graph.addEdge(new Collaboration_Sec22_G15(i5, i1, "Project 5"));
        graph.addEdge(new Collaboration_Sec22_G15(i6, i2, "Project 6"));
        graph.addEdge(new Collaboration_Sec22_G15(i7, i10, "Project 7"));
        graph.addEdge(new Collaboration_Sec22_G15(i8, i4, "Project 8"));
        graph.addEdge(new Collaboration_Sec22_G15(i9, i6, "Project 9"));
        graph.addEdge(new Collaboration_Sec22_G15(i10, i9, "Project 10"));
        graph.addCluster(i1, "Health");
        graph.addCluster(i4, "Safety");
        graph.addEdge(new Collaboration_Sec22_G15(i11, i4, "Project 11"));
        Individual_Sec22_G15 i12 = new Individual_Sec22_G15("I12", "Outsider", "Software Engineer");
        graph.addVertex(i12);
        graph.addEdge(new Collaboration_Sec22_G15(i11, i12, "Project 12"));
    }
}
