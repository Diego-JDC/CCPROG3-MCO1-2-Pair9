public class Item {
    private String name;
    private int calories;
    private int price;

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
