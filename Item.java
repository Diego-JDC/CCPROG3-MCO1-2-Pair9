public class Item {
    private String name;
    private int quantity;
    private double calories;
    private double price;

    public Item(String name, double calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.quantity = 0;
    }

    public void addStock(int amount) {
        this.quantity += amount;
    }

    public void setPrice(double amount) {
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

    public double getPrice() {
        return this.price;
    }
}
