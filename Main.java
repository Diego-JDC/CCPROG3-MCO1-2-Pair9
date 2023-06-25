import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory("Factory 1");

        Scanner scan = new Scanner(System.in);
        System.out.println("   === MENU === \n");
        System.out.println("Select feature to test : \n");
        System.out.println("[ 1 ] Vending Features");
        System.out.println("[ 2 ] Maintenance Features");
        System.out.println("[ 3 ] Exit");

        int choice;
        do {
            System.out.println("Enter choice : ");
            choice = scan.nextInt();
            if(choice != 1 || choice != 2)
                System.out.println("Invalid choice! try again. \n");
        }while(choice != 1 || choice != 2);

        double money;
        int choice2;

        if(choice == 1){
            System.out.println("=== TESTING VENDING FEATURES ===");
            System.out.println("Input cash value: ");
            money = scan.nextDouble();
            factory.testVendingFeatures(money);
        }
        else if(choice == 2){
            factory.machineMaintenance();
        }
    }
}
