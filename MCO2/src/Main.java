//package src;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Factory factory = new Factory("Factory 1");

        // GUI
        ViewMenu view = new ViewMenu();
        view.setVisible(true);
        Controller cont = new Controller(view, factory);
        //

        VendingMachine vm1 = new VendingMachine("Vending Machine 1");
        System.out.println("Created vending machine : " + vm1.getName());

        Item marshmallows = new Item("Marshmallows", 200.0, 30);
        Item chocolate = new Item("Chocolate", 100.0, 20);
        Item iceCream = new Item("Ice Cream", 350.0, 40);
        Item wafers = new Item("Wafers", 20.0, 10);
        Item cookies = new Item("Cookies", 35.0, 25);
        Item strawberries = new Item("Strawberries", 15.0, 16);
        Item water = new Item("Water bottle", 0, 12);
        Item banana = new Item("Banana", 17.5, 22);
        Item mango = new Item("Mango", 22, 17);
        Item milk = new Item("Milk bottle", 22, 100);
        Item pineapple = new Item("Pineapple", 2, 7);

        vm1.addItem(marshmallows);
        vm1.addItem(chocolate);
        vm1.addItem(iceCream);
        vm1.addItem(wafers);
        vm1.addItem(cookies);
        vm1.addItem(strawberries);
        vm1.addItem(water);
        vm1.addItem(banana);
        vm1.addItem(mango);
        vm1.addItem(milk);
        vm1.addItem(pineapple);

        vm1.addItemQuantity(marshmallows, 10);
        vm1.addItemQuantity(chocolate, 10);
        vm1.addItemQuantity(iceCream, 10);
        vm1.addItemQuantity(wafers, 11);
        vm1.addItemQuantity(cookies, 12);
        vm1.addItemQuantity(strawberries, 13);
        vm1.addItemQuantity(water, 9);
        vm1.addItemQuantity(banana, 16);

        factory.addToVendingMachineList(vm1);

        
        int choice = 0;
        do {
            System.out.println("\nFactory : " + factory.getName());
            System.out.println("=== MENU ===");
            System.out.println("Select feature to test:");
            System.out.println("[ 1 ] Create a vending machine");
            System.out.println("[ 2 ] Vending Features");
            System.out.println("[ 3 ] Maintenance Features");
            System.out.println("[ 4 ] Exit");

            do {
                System.out.print("Enter choice : ");
                choice = scan.nextInt();

                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    System.out.println("Invalid choice! Try again.\n");
                }
            } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

            String vmName;

            if (choice == 1) {
                scan.nextLine();
                System.out.println("Input name of vending machine: ");
                vmName = scan.nextLine();
                factory.makeVendingMachine(vmName);

            }
            else if (choice == 2) {
                if(!factory.isVendingMachineListEmpty()) {
                    factory.testVendingFeatures(factory.getCurrentMachine());
                }
                else {
                    System.out.println("There are no vending machines!");
                }
            }
            else if (choice == 3) {
                factory.machineMaintenance(factory.getCurrentMachine());
            }
            
        } while (choice != 4);
        scan.close();
    }
}