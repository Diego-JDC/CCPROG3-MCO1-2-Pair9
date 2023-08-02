/**
 * Item class that holds properties of an item
 */

public class Item {
    private String name;
    private int calories;
    private int price;

    /**
     * Constructor
     * @param name name of item
     * @param calories number of calories of an item
     * @param price price of an item
     */

    public Item(String name, int calories, int price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public void setPrice(int amount) {
        this.price = amount;
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

}
