import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private String name;
    private ArrayList<Item> inventory;
    private int balance; // denominations are 1, 5, 10, 20, 50, 100 PHP
    private int income;
    private final int itemCapacity = 15; // temp : can be set by factory if needed, just remove final and add more to constructors. 
    
    //constructors
    public VendingMachine(String name, int balance) {
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



    public int displayItems(){
        int num = 1;
        for(Item i : inventory){
            System.out.println("[ " + inventory.indexOf(i) + " ] "+ i.getName() + ", " + i.getPrice() + ", " + "Stock: " + i.getQuantity() + " Calories: " + i.getCalories());
            num++;
        }

        return num;
    }

    public boolean addItem(String name, double calories, int price) {
        boolean valid = true;
        if(calories < 0) {
            System.out.println("Invalid calories set!");
            if(price < 0) {
                System.out.println("Invalid price set!");
            }
            valid = false;
        }
        Item n = new Item(name, calories, price);
        inventory.add(n);
        return valid;
    }

    public boolean addItemQuantity(Item item, int amount) {
        boolean valid = true;
        if(amount <= 0) {
            System.out.println("Invalid amount!");
            valid = false;
        }
        item.addQuantity(amount);
        //System.out.println(item.getName() + " : " + "Added " + amount + " stock.");
        return valid;
    }

    public void stockUp() {
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean valid = false;
        do {
            do {
                System.out.println("Select option :");
                System.out.println("[ 1 ] Add items");
                System.out.println("[ 2 ] Restock existing items");
                System.out.println("[ 3 ] Back to previous menu");
                System.out.println("Enter choice : ");
                choice = scan.nextInt(); 
                
                if(choice != 1 || choice != 2 || choice != 3) {
                    System.out.println("Invalid input! Try again");
                }
            } while(choice != 1 || choice != 2 || choice != 3);

            //checks to make sure restocking already has existing items in inventory
            //regardless if their quantity is 0 or not 
            if(choice == 2) {
                if(inventory.isEmpty() == false) {
                    valid = true;
                }
                else {
                    System.out.println("Inventory is empty! Add items first.");
                }
            }
        } while(valid == false);
        
        switch(choice) {
             // case 1 : adding items via maintenance mode
            case 1 : double calories; 
                     int price;
                     String name;
                     System.out.println("===ADDING A NEW ITEM===");
                     do {
                        System.out.println("Enter item name : ");
                        name = scan.nextLine();
                        System.out.println("Enter calories : ");
                        calories = scan.nextDouble();
                        System.out.println("Enter price : ");
                        price = scan.nextInt();
                    } while(addItem(name, calories, price) == false);
                    break;
            // case 2 : restocking previously added items via maintenance mode
            case 2 : int c, amount;
                     System.out.println("===RESTOCKING ITEMS===");
                     do {
                        System.out.println("------ITEM LIST------");
                        displayItems();
                        do {
                            System.out.println("Enter index of your choice : ");
                            c = scan.nextInt();
                            if(c < 0 || c >= inventory.size()) {
                                System.out.println("Invalid index! Try again.");
                            }
                        } while (c < 0 || c >= inventory.size());
                        
                        System.out.println("Enter amonut to add : ");
                        amount = scan.nextInt();
                     } while(addItemQuantity(inventory.get(c), amount) == false); 
                     break;                               
        }

        scan.close();
    }

    public boolean setPrice(Item item, int newPrice) {
        boolean valid = true;
        if(newPrice < 0) { // protecting programmer/driver from invalid prices
            System.out.println("Invalid price!");
            valid = false;
        }
        item.setPrice(newPrice);
        //System.out.println(item.getName() + " : " + "updated price to " + newPrice);
        return valid;
    }

    public void setPriceMenu() {
        
        if(this.inventory.isEmpty() == false) {
            Scanner scan = new Scanner(System.in);
            int index, newPrice;
            System.out.println("===UPDATE ITEM PRICE===");
            System.out.println("------ITEM LIST------");
            displayItems();
            do {
                System.out.println("Enter index of your choice : ");
                index = scan.nextInt();

                System.out.println("Enter new price : ");
                newPrice = scan.nextInt();

                if(index < 0 || index >= inventory.size()) {
                    System.out.println("Invalid index! Try again.");
                }
                if(newPrice < 0) {
                    System.out.println("Invalid price! Try again.");
                }

            } while (index < 0 || index >= inventory.size() || newPrice < 0); //protecting user from invalid price & index.
            setPrice(inventory.get(index), newPrice);

            scan.close();
        }
        else {
            System.out.println("Inventory is empty! add items first.");
        }

    }

    public boolean updateBalance() {

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
