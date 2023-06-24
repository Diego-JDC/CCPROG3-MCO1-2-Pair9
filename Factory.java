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

    public void machineMaintenance(){
        System.out.println("=== MAINTENANCE FEATURES ===");
        System.out.println("[ 1 ] Restock items");
        System.out.println("[ 2 ] Stock items");
        System.out.println("[ 3 ] Collect income");
        System.out.println("[ 4 ] Set item price");
        System.out.println("[ 5 ] Replenish system funds");
    }
}
