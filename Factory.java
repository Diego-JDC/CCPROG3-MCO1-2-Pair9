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
        return vendingMachineList.get(n);
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

            if(confirm == Y){
                // Checks if the vending machine can produce change
                valid = machine.isValidTransaction(choice-1, moneyInput, itemNum);
            }

        }while(choice > 5 || choice < 1 && valid == false);

        sc.close();
    }

}
