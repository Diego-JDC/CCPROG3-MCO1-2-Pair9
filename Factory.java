import java.util.ArrayList;
import java.util.Scanner;

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private Item item;

    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
    }

    public void makeVendingMachine(String name) {
        VendingMachine n = new VendingMachine(name);
        vendingMachineList.add(n);
    }
    
    public void makeVendingMachine(String name, double startingBalance) {
        VendingMachine n = new VendingMachine(name, startingBalance);
        vendingMachineList.add(n);
    }

    public VendingMachine getCurrentMachine(){
        int n = vendingMachineList.size();
        return vendingMachineList.get(n-1);
    }

    public void testVendingFeatures(double money){
        System.out.println("    === TESTING VENDING FEATURES ===");
        VendingMachine machine = getCurrentMachine();
        Scanner sc = new Scanner(System.in);

        // Gets item choice and input cash of user
        int choice;
        double moneyInput;
        int itemNum = 0;
        boolean valid = false;
        String confirm;

        do{
            itemNum = machine.displayItems();
            System.out.println("Select item: ");
            choice = sc.nextInt();
            System.out.println("Please input cash: ");
            moneyInput = sc.nextDouble();
            System.out.println("Proceed with transaction? [Y]es [N]o");
            confirm = sc.nextLine();

            if(confirm.equals("Y") || confirm.equals("y")){
                // Checks if the vending machine can produce change
                valid = machine.isValidTransaction(choice-1, moneyInput, itemNum);
            }

        }while(choice > 5 || choice < 1 && !valid);

        sc.close();
    }

    public void machineMaintenance(VendingMachine vm){
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== MAINTENANCE FEATURES ===");
            System.out.println("[ 1 ] Stock/Restock items");
            System.out.println("[ 2 ] Collect income");
            System.out.println("[ 3 ] Set item price");
            System.out.println("[ 4 ] Replenish system funds");
            System.out.println("[ 5 ] Back to main menu");
            System.out.println("Enter choice : ");
            choice = scan.nextInt();

            if(choice > 5 || choice < 1) {
                System.out.println("Invalid input! Try again.");
            }

        } while(choice > 5 || choice < 1);
        
        switch(choice) {
            case 1 : vm.stockUp();
                     break;
            case 2 : //function to collect income
                     break;
            case 3 : //vm.setItemPrice
                     break;
            case 4 : //updateBalance() ??
                     break;
        }
        
        scan.close();
    }
}
