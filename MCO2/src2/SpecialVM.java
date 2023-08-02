import java.util.ArrayList;

/**
 * Child class of VendingMachine class
 */

public class SpecialVM extends VendingMachine {
    private ArrayList<Slot> specialInventory;

    /**
     * Constructor
     * @param name name of special vending machine
     */

    public SpecialVM(String name) {
        super(name);
        this.specialInventory = new ArrayList<Slot>();

        Ingredient shavedIce = new Ingredient("Shaved Ice", 0, 10, "Shaving ice...", "Base");
        Slot ShavedIce = new Slot("Shaved Ice", shavedIce.getCalories(), shavedIce.getPrice());
        this.specialInventory.add(ShavedIce);
        ShavedIce.setInitQuantity(0);
        ShavedIce.addItem(shavedIce);
        stockItem(shavedIce, 10);
    }

    public ArrayList<Slot> getSpecialInventory() {
        return this.specialInventory;
    }

    /**
     * Stocks a specific number of an item
     * @param item ingredient object
     * @param amount amount to be stocked
     */

    public void stockItem(Ingredient item, int amount){
        String itemName = item.getName().toLowerCase();

        for(Slot s : this.specialInventory){
            String slotName = s.getName().toLowerCase();

            if(slotName.equals(itemName)){
                s.addItem(item, amount);
                s.setInitQuantity(amount - 1);
            }
        }
    }

    /**
     * Checks if every slot in special inventory is empty (no more item instances in it)
     * @return boolean value. True is the inventory has slots but is all out of stock, otherwise return false
     */
    @Override
    public boolean isAllOutOfStock() {
        boolean result = true;
        for(Slot s : specialInventory) {
            if(!s.getItemList().isEmpty()) {
                result = false;
            }
        }
        return result;
    }
}
