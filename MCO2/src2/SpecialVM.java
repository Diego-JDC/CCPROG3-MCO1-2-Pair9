import java.util.ArrayList;

public class SpecialVM extends VendingMachine {
    private ArrayList<Slot> specialInventory;
    private ArrayList<Item> currentOrder;

    //order of operations for ingredient preparation
    //checks based on name/type (type is aaplicable)
    private String[] ingredientOrder = {"Shaved Ice","Powdered Milk", 
                                         "Extract", "Food Color", "Topping"};

    public SpecialVM(String name) {
        super(name);
        this.specialInventory = new ArrayList<Slot>();
        this.currentOrder = new ArrayList<Item>();

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

    public ArrayList<Item> getCurrentOrder() {
        return this.currentOrder;
    }

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
