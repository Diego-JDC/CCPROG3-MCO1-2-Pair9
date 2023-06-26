import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a vending machine factory.
 */

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private Item item;

    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
    }

    /***
     * Function to make a new vending machine.
     * @param name Vending machine name
     */
    public void makeVendingMachine(String name) {
        VendingMachine n = new VendingMachine(name);
        vendingMachineList.add(n);
    }

    /**
     * Gets most recently created vending machine.
     * @return  Vending machine object
     */

    public VendingMachine getCurrentMachine(){
        int n = vendingMachineList.size();
        if(n != 0) {
            return vendingMachineList.get(n-1);
        }
        else{
            return null;
        }
    }

    /**
     * Tests vending features.
     */

    public void testVendingFeatures(){
        System.out.println("=== TESTING VENDING FEATURES ===");
        VendingMachine machine = getCurrentMachine();
        Scanner sc = new Scanner(System.in);

        // Gets item choice and input cash of user
        int choice;
        int moneyInput;
        int itemNum;
        boolean valid = false;
        int confirm;

        if(vendingMachineList.size() > 0 && machine.getInventorySize() != 0){
            itemNum = machine.displayItems();
            System.out.println("Select item: ");
            choice = sc.nextInt();
            System.out.println("[Accepted inputs: 1, 5, 10, 20, 50, 100 PHP]");
            do{
                System.out.print("Input cash: ");
                moneyInput = sc.nextInt();
            }while(!machine.isValidDenomination(moneyInput));

            System.out.print("Proceed with transaction? [1]Yes [2]No");
            confirm = sc.nextInt();

            if(confirm == 1){
                // Checks if the transaction can push through
                valid = machine.isValidTransaction(choice-1, moneyInput, itemNum);
                if(valid){
                    System.out.println("Valid. (nothing here yet)");
                }
                else{
                    System.out.println("Error in transaction. Please try again later.");
                }
            }
            else{
                System.out.println("Transaction cancelled. Returning " + moneyInput + " PHP");
            }
        }

        else if(vendingMachineList.size() == 0){
            System.out.println("There are no vending machines created yet.");
            System.out.println("Press any key to continue...");
            sc.next();
        }

        else if(machine.getInventorySize() == 0){
            System.out.println("There are no items in the vending machine yet.");
            System.out.println("Press any key to continue...");
            sc.next();
        }
    }

    /**
     * Edits components of the vending machine.
     * @param vm Vending machine object
     */

    public void machineMaintenance(VendingMachine vm){
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== MAINTENANCE FEATURES ===");
            System.out.println("[ 1 ] Add or Stock/Restock items");
            System.out.println("[ 2 ] Collect income");
            System.out.println("[ 3 ] Set item price");
            System.out.println("[ 4 ] Replenish system funds");
            System.out.println("[ 5 ] Back to main menu");
            System.out.println("Enter choice: ");
            choice = scan.nextInt();

            if(choice > 5 || choice < 1) {
                System.out.println("Invalid input! Try again.");
            }

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

        } while(choice > 5 || choice < 1);
    }
}
