import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private String name;
    private ArrayList<Item> inventory;
    private int balance; // denominations are 1, 5, 10, 20, 50, 100 PHP
    private int income;
    private final int itemCapacity = 15; // temp : can be set by factory if needed, just remove final and add more to constructors. 
    
    //constructors
    public VendingMachine(String name, int balance) { // Maybe we should delete so that the balance can only
                                                      // be changed through the maintenance tab
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

    /**
     * Gets the amount of money inside the vending machine.
     * @return Money balance of machine
     */
    public int getBalance(){
        return this.balance;
    }

    /**
     * Displays all items.
     * @return Number of items
     */
    public int displayItems(){
        int num = 0;
        for(Item i : inventory){
            System.out.println("[ " + inventory.indexOf(i) + " ] "+ i.getName() + ", " + i.getPrice());
            System.out.println("Stock: " + i.getQuantity() + "  Calories: " + i.getCalories());
            num++;
        }
        return num;
    }

    /**
     * Adds a new item to the vending machine.
     * @param name Name of item
     * @param calories Amount of calories
     * @param price Price of item
     * @return boolean value
     */
    public boolean addItem(String name, double calories, int price) {
        boolean valid = true;
        if(calories < 0) {
            System.out.println("Invalid calories set!");
            valid = false;
        }
        else if(price < 0) {
            System.out.println("Invalid price set!");
            valid = false;
        }

        Item n = new Item(name, calories, price);
        inventory.add(n);
        return valid;
    }

    /**
     * Adds more of a particular item.
     * @param item Item object
     * @param amount Number of items to be added
     * @return Boolean value
     */

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

    /**
     * Restocks or adds items.
     */

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

                if(choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Invalid input! Try again");
                }
            } while(choice != 1 && choice != 2 && choice != 3);

            if(choice == 1){
                if(inventory.size() <= itemCapacity){
                    valid = true;
                }
            }

            //checks to make sure restocking already has existing items in inventory
            //regardless if their quantity is 0 or not
            if(choice == 2) {
                if(!inventory.isEmpty()) {
                    valid = true;
                }
                else {
                    System.out.println("Inventory is empty! Add items first.");
                }
            }
        } while(!valid);

        switch(choice) {
            // case 1 : adding items via maintenance mode
            case 1 : double calories;
                int price;
                String name;
                System.out.println("===ADDING A NEW ITEM===");
                do {
                    System.out.println("Enter item name : ");
                    scan.nextLine(); // Removes scanning error
                    name = scan.nextLine();
                    System.out.println("Enter calories : ");
                    calories = scan.nextDouble();
                    System.out.println("Enter price : ");
                    price = scan.nextInt();
                } while(!addItem(name, calories, price));
                break;
            // case 2 : restocking previously added items via maintenance mode
            case 2 : int c, amount;
                System.out.println("===RESTOCKING ITEMS===");
                do {
                    System.out.print("\n");
                    System.out.println("------ITEM LIST------");
                    displayItems();
                    do {
                        System.out.println("Enter index of your choice : ");
                        c = scan.nextInt();
                        if(c < 0 || c >= inventory.size()) {
                            System.out.println("Invalid index! Try again.");
                        }
                    } while (c < 0 || c >= inventory.size());

                    System.out.println("Enter amount to add : ");
                    amount = scan.nextInt();
                } while(!addItemQuantity(inventory.get(c), amount));
                break;
        }
    }

    /**
     * Sets the price of an item.
     * @param item Item object
     * @param newPrice New item price
     * @return Boolean value
     */

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

    /**
     * Picks an item to set a new price in the menu.
     */

    public void setPriceMenu() {
        
        if(!this.inventory.isEmpty()) {
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

    /**
     * Updates the balance of the machine.
     * @return New balance
     */

    //public boolean updateBalance() {

    //}

    /**
     * Gets the price of an item given item index.
     * @param index Index of an item inside inventory
     * @return Price of the item
     */
    public int getItemPrice(int index){
        Item item = inventory.get(index);
        return item.getPrice();
    }

    public int computeChange(int money, int price){
        return price-money;
    }

    /**
     * Verifies if a transaction is valid.
     * @param index Index of the item chosen
     * @param money Money given by the user
     * @param itemNum Number of items currently in inventory
     * @return Boolean value
     */

    public boolean isValidTransaction(int index, int money, int itemNum) {

        /*
         * Not valid if:
         * - Item selected is < 0 or > itemNum
         * - Machine does not have enough money to give change
         * - User does not give enough money
         */

        boolean valid = true;
        int change = computeChange(money, getItemPrice(index));

        if(index > itemNum || index < 0){
            valid = false;
        }
        else if(money < getItemPrice(index)){
            valid = false;
        }
        else if(change > getBalance()){
            valid = false;
        }

        return valid;
    }

    /**
     * Replenishes the machine balance.
     * @param amount Amount of money to be added
     */

    public void replenishBalance(int amount) {
        this.balance += amount;
    }

    /**
     * Checks if the user inputs a valid denomination.
     * @param input Money inputted by user
     * @return Boolean value
     */

    public boolean isValidDenomination(int input){
        int[] validInputs = new int[] {1, 5, 10, 20, 50, 100};
        boolean valid = false;

        for(int i : validInputs){
            if(i == input){
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Gets number of items in inventory.
     * @return Number of items
     */
    public int getInventorySize(){
        return this.inventory.size();
    }

    public void transactionSummary() {

    }

    /**
     * Adds an item to the item list.
     * @param item Item input of user
     */
    public void updateItemList(Item item){
        this.inventory.add(item);
    }
}
