import java.util.Scanner;
public class Main_Sec22_G15 {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            try {
                menu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addContributor();
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
        System.out.println("5. Print the graph");
        System.out.println("0. Exit");
    }

    public static void addContributor() {
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
    }
}
