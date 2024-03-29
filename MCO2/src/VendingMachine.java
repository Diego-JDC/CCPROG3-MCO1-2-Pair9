//package src;
import java.util.ArrayList;

public class VendingMachine {
    private String name;
    private ArrayList<Item> inventory;
    private int balance; // denominations are 1, 5, 10, 20, 50, 100 PHP
    private int income;
    private final int itemCapacity = 15; // the maximum quantity of items per slot
    private final int inventoryCapacity = 10; // max slots the machine can accomodate.
    
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

    /**
     * Gets the amount of money inside the vending machine.
     * @return money balance of machine
     */
    public int getBalance(){
        return this.balance;
    }

    /**
     * Displays all items.
     */
    public int displayItems(){
        int num = 0;
        for(Item i : inventory){
            System.out.println("[ " + inventory.indexOf(i) + " ] "+ i.getName() + ", " + i.getPrice() + " PHP");
            System.out.println("Stock: " + i.getQuantity() + "  Calories: " + i.getCalories() + "\n");
            num++;
        }
        return num;
    }

    /**
     * Adds a new item to the vending machine.
     * @param name name of item
     * @param calories amount of calories
     * @param price price of item
     * @return boolean value
     */

    public boolean addItem(String name, double calories, int price) {
        boolean valid = true;
        if(calories < 0) {
            System.out.println("Invalid calories set!");
            valid = false;
        }
        else if(price < 0 || price > 100) { 
            System.out.println("Invalid price set!");
            valid = false;
        }
        else if(inventory.size() + 1 > this.inventoryCapacity) {// + 1 because this would be *if* an extra item is added
            System.out.println("Machine has reached max capacity for items!\n");
            valid = false;
        }
        if(valid == true) {
            Item n = new Item(name, calories, price);
            inventory.add(n);
            System.out.println("Successfully added " + name + "!\n");
        }
        
        return valid;
    }

    /**
     * Adds an item to the vending machine.
     * @param item item object to be added
     */

    public void addItem(Item item) {
        if(inventory.size() + 1 > this.inventoryCapacity) { // + 1 because this would be *if* an extra item is added
            System.out.println("Tried adding " + item.getName());
            System.out.println("\tError : Machine has reached max capacity for items!\n");
        }
        else {
            inventory.add(item);
            System.out.println("Successfully added " + item.getName() + "!");
        }
        
    }

    /**
     * Adds more of a particular item.
     * @param item item object
     * @param amount number of items to be added
     * @return boolean value
     */

    public boolean addItemQuantity(Item item, int amount) {
        boolean valid = true;
        if(amount <= 0) {
            System.out.println("Invalid amount!");
            valid = false;
        }

        if(item.getQuantity() + amount > this.itemCapacity) {
            System.out.println("Error : Tried to add " + amount + " of " + item.getName() );
            System.out.println("    Amount exceeds maximum item capacity! (Max : 15)");
            valid = false;
        }

        if(valid == true) {
            item.addQuantity(amount);
            System.out.println(item.getName() + " : " + "Added " + amount + " stock.");
        }
        
        return valid;
    }

    /**
     * Sets the price of an item.
     * @param item item object
     * @param newPrice new item price
     * @return boolean value
     */

    public boolean setPrice(Item item, int newPrice) {
        boolean valid = true;
        if(newPrice < 0 || newPrice > 100) { // protecting programmer/driver from invalid prices
            System.out.println("Invalid price!");
            valid = false;
        }
        item.setPrice(newPrice);
        System.out.println(item.getName() + " : " + "updated price to " + newPrice + " PHP");
        return valid;
    }

    /**
     * Updates the balance of the machine for change
     * @param change amount of money to take from the machine's balance for change.
     * @return boolean value. True if there is enough for change
     */

    public boolean updateBalance(int change) {
        boolean result = true;
        if(balance < change) { // there isn't enough money for change
            result = false;
        }
        else { // we can assume that the balance is >= amount
            this.balance -= change;
        }
        return result;
    }

    /**
     * Gets the price of an item given item index.
     * @param index index of an item inside inventory
     * @return price of the item
     */
    public int getItemPrice(int index){
        Item item = inventory.get(index);
        return item.getPrice();
    }

    /**
     * Gets the name of an item.
     * @param index index of an item inside inventory
     * @return name of item
     */
    
    public String getItemName(int index) {
        Item item = inventory.get(index);
        return item.getName();
    }

    /**
     * Computes for the change after buying an item.
     * @param money money inputted by user
     * @param price price of the item
     * @return change
     */
    
    public int computeChange(int money, int price){
        return price-money;
    }

    /**
     * Verifies if a transaction is valid.
     * @param index index of the item chosen
     * @param money money given by the user
     * @param itemNum number of items currently in inventory
     * @return boolean value
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
     * Checks if the user inputs a valid denomination.
     * @param input money inputted by user
     * @return boolean value
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
     * @return number of items
     */
    public int getInventorySize(){
        return this.inventory.size();
    }

    /**
     * Adds an item to the item list.
     * @param item item input of user
     */
    public void updateItemList(Item item){
        this.inventory.add(item);
    }

    /**
     * Updates stock whenever a successful transaction is made.
     * @param index index of the item in the inventory of the machine 
     */
    public void updateStock(int index) {
        Item item = inventory.get(index);
        item.removeStock(1);
    }

    /**
     * Adds the amount of income when collected by user.
     * @param amount the amount to be collected
     */

    public void addIncome(int amount) {
        this.income += amount;
    }

   
    /**
     * Replenishes the machine balance.
     * @param amount amount of money to be added
     */

    public void addBalance(int amount) {
        this.balance += amount;
    }

    /**
     * Gets the item capacity of the vending machine.
     * @return item capacity of vending machine
     */

    public int getItemCapacity() {
        return this.itemCapacity;
    }

    /**
     * Gets the income from all purchases unclaimed.
     * @return amount of income
     */

    public int getIncome() {
        return this.income;
    }

    /**
     * Sets the amount of income based on amount collected.
     * @param amount amount of income currently collected
     */

    public void setIncome(int amount) {
        this.income = amount;
    }

    /**
     * Gets an item inside inventory based on index.
     * @param index index of item
     * @return item object
     */

    public Item getItem(int index) {
        return inventory.get(index);
    }

    /**
     * Gets the inventory array list containing all items.
     * @return inventory array list
     */

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    /**
     * Gets the name of the vending machine.
     * @return name of machine
     */

    public String getName() {
        return this.name;
    }

    /**
     * Gets the current maximum capacity of inventory space.
     * @return inventory capacity
     */

    public int getInventoryCapacity() {
        return this.inventoryCapacity;
    }
}
