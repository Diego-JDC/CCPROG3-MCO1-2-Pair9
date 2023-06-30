//package src;
public class Item {
    private String name;
    private int quantity;
    private double calories;
    private int price;
    private int initQuantity;

    /**
     * Constructor
     * @param name name of item
     * @param calories number of calories of an item
     * @param price price of an item
     */

    public Item(String name, double calories, int price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.quantity = 0;
        this.initQuantity = 0;
    }

    /**
     * Constructor
     * @param name name of item
     * @param calories number of calories of an item
     * @param price price of an item
     * @param initQuantity initial quantity of an item before any purchases
     */

    public Item(String name, double calories, int price, int initQuantity) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.quantity = initQuantity;
        this.initQuantity = initQuantity;
    }

    /**
     * Removes a certain amount of an item.
     * @param amount amount to remove
     */

    public void removeStock(int amount) {
        this.quantity -= amount;
    }

    /**
     * Sets the price of an item.
     * @param amount new price of the item
     */

    public void setPrice(int amount) {
        this.price = amount;
    }

    /**
     * Gets the name of the item.
     * @return name of item
     */

    public String getName() {
        return this.name;
    }

    /**
     * Gets the quantity of the item in stock.
     * @return amount in stock
     */

    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the amount of calories of the item.
     * @return amount of calories.
     */

    public double getCalories() {
        return this.calories;
    }

    /**
     * Gets the price of the item.
     * @return price of item
     */

    public int getPrice() {
        return this.price;
    }

    /**
     * Adds a certain amount of an item to stock.
     * @param amount amount to be added
     */

    public void addQuantity(int amount) {
        this.quantity += amount;
        this.initQuantity = quantity; 
    }

    /**
     * Gets the initial quantity of an item.
     * @return initial quantity
     */

    public int getInitQuantity() {
        return this.initQuantity;
    }
}
