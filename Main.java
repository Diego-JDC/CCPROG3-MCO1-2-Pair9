import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory("Factory 1");
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=== MENU ===");
            System.out.println("Select feature to test:");
            System.out.println("[ 1 ] Create a vending machine");
            System.out.println("[ 2 ] Vending Features");
            System.out.println("[ 3 ] Maintenance Features");
            System.out.println("[ 4 ] Exit");

            do {
                System.out.println("Enter choice : ");
                choice = scan.nextInt();

                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    System.out.println("Invalid choice! Try again.\n");
                }
                else if (choice == 4) {
                    break;
                }
            } while (choice != 1 && choice != 2 && choice != 3);

            String vmName;

            if (choice == 1) {
                scan.nextLine();
                System.out.println("Input name of vending machine: ");
                vmName = scan.nextLine();
                factory.makeVendingMachine(vmName);

            }
            else if (choice == 2) {
                factory.testVendingFeatures();
            }
            else if (choice == 3) {
                factory.machineMaintenance(factory.getCurrentMachine());
            }
        } while (choice != 4);

        scan.close();
    }
}