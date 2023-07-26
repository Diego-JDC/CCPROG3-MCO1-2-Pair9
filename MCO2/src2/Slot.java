package MCO2.src2;

import java.util.ArrayList;

public class Slot {
    private String name;
    private ArrayList<Item> itemList;
    private int initQuantity;

    public Slot(String name) {
        this.name = name;
        this.itemList = new ArrayList<Item>();
        this.initQuantity = 0;
    }

    public void addItem(Item i) {
        itemList.add(i);
    }

    public void addItem(Item i, int amount) {
        for(int j = 0; j < amount; j++) {
            itemList.add(i);
        }
    }

    //removes the first Item in the array
    public void sellItem() {
        itemList.remove(itemList.get(0));
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

    public void setInitQuantity(int qty) {
        this.initQuantity = qty;
    }
}
