import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private String name;
    private ArrayList<Item> inventory;
    private double balance;
    private double income;
    
    public VendingMachine(String name, double balance) {
        this.name = name;
        this.inventory = new ArrayList<Item>();
        this.balance = balance;
        this.income = 0;
    }

    public VendingMachine(String name) {
        this.name = name;
        this.inventory = new ArrayList<Item>();
        this.balance = 0;
        this.income = 0;
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("   === MENU === \n");

        System.out.println("Select feature to test : \n");

        System.out.println("[ 1 ] Vending Features");
        System.out.println("[ 2 ] Maintenance Features");

        int choice;
        do {
            System.out.println("Enter choice : ");
            choice = scan.nextInt();
            if(choice != 1 || choice != 2)
                System.out.println("Invalid choice! try again. \n");
        }while(choice != 1 || choice != 2);
        
        if(choice == 1) {
            vendingFeatures();
        } else {
            maintenance();
        }
        

    }

    /*

    private void vendingFeatures() {
        System.out.println("   ===VENDING FEATURES=== \n");
    }

    private void maintenance() {
        System.out.println("   ===MAINTENANCE FEATURES=== \n");
    }

    */

    public int displayItems(){
        int num = 1;
        for(Item i : inventory){
            System.out.println("[ " + num + " ] "+ i.getName() + ", " + i.getPrice() + ", " + "Stock: " + i.getQuantity() + " Calories: " + i.getCalories());
            num++;
        }

        return num;
    }

    private void stockUp() {

    }

    public boolean collectIncome() {

    }

    public boolean isValidTransaction(int index, double money, int itemNum) {
        boolean valid = true;

        /*
         * Not valid if:
         * - Item selected is < 0 or > itemNum
         * - Machine does not have enough money to give change
         * - User does not give enough money
         */

        if(index > itemNum || index < 0){
            valid = false;
        }
        else if()

        return valid;
    }

    private void replenishBalance(double amount) {
        this.balance += amount;
    }

    private void transactionSummary() {
        
    }
}
