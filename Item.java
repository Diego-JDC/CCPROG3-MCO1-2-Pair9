public class Item {
    private String name;
    private int quantity;
    private double calories;
    private int price;
    private int initQuantity;

    public Item(String name, double calories, int price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.quantity = 0;
        this.initQuantity = 0;
    }

    public Item(String name, double calories, int price, int initQuantity) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.quantity = initQuantity;
        this.initQuantity = initQuantity;
    }

    public void addStock(int amount) {
        this.quantity += amount;
    }

    public void removeStock(int amount) {
        this.quantity -= amount;
    }

    public void setPrice(int amount) {
        this.price = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getCalories() {
        return this.calories;
    }

    public int getPrice() {
        return this.price;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
        this.initQuantity = quantity; 
    }

    public int getInitQuantity() {
        return this.initQuantity;
    }

}
