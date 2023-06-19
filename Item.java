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

    private void addStock(int amount) {
        this.quantity += amount;
    }

    private void setPrice(double amount) {
        this.price = amount;
    }

    private String getName() {
        return this.name;
    }

    private int getQuantity() {
        return this.quantity;
    }

    private double getCalories() {
        return this.calories;
    }

    private double getPrice() {
        return this.price;
    }
}
