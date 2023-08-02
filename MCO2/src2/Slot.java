import java.util.ArrayList;

/**
 * Slot class that holds list of items
 */

public class Slot {
    private String name;
    private ArrayList<Item> itemList;
    private int initQuantity;
    private int calories;
    private int price;

    /**
     * Constructor
     * @param name name of slot
     * @param calories number of calories for all items
     * @param price price of the item
     */

    public Slot(String name, int calories, int price) {
        this.name = name;
        this.itemList = new ArrayList<Item>();
        this.initQuantity = 0;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Adds an item to the itemList
     * @param i item object
     */

    public void addItem(Item i) {
        itemList.add(i);
    }

    /**
     * Adds a specific number of items to the itemList
     * @param i item object
     * @param amount amount added
     */

    public void addItem(Item i, int amount) {
        for(int j = 0; j < amount; j++) {
            itemList.add(i);
        }
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public int getInitQuantity () {
        return this.initQuantity;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getPrice() {
        return this.price;
    }

    public void setInitQuantity(int qty) {
        this.initQuantity = qty;
    }

    /**
     * Gets price of an individual item
     * @return price of items in itemList
     */
    public int getItemPrice(){
        return this.itemList.get(0).getPrice();
    }

    /**
     * Sets the price for all items
     * @param price new item price
     */

    public void setItemPrice(int price){
        this.price = price;
        for(Item i : itemList){
            i.setPrice(price);
        }
    }

    // This is to display the item name for combo box in maintenance menu
    @Override
    public String toString(){
        return getName();
    }
}
