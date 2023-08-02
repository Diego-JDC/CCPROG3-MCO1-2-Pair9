import java.util.ArrayList;

public class Slot {
    private String name;
    private ArrayList<Item> itemList;
    private int initQuantity;
    private int calories;
    private int price;

    public Slot(String name, int calories, int price) {
        this.name = name;
        this.itemList = new ArrayList<Item>();
        this.initQuantity = 0;
        this.calories = calories;
        this.price = price;
    }

    public void addItem(Item i) {
        itemList.add(i);
    }

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

    // Gets price of an individual item
    public int getItemPrice(){
        return this.itemList.get(0).getPrice();
    }

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
