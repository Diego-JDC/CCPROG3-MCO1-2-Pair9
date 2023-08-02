import java.util.ArrayList;

public class SpecialVM extends VendingMachine {
    private ArrayList<Slot> specialInventory;
    private ArrayList<Item> currentOrder;
    private int totalCalories;

    //order of operations for ingredient preparation
    //checks based on name/type (type is aaplicable)
    private String[] ingredientOrder = {"Shaved Ice","Powdered Milk", 
                                         "Extract", "Food Color", "Topping"};

    public SpecialVM(String name) {
        super(name);
        this.specialInventory = new ArrayList<Slot>();
        this.currentOrder = new ArrayList<Item>();
        this.totalCalories = 0;

        Ingredient shavedIce = new Ingredient("Shaved Ice", 0, 10, "Shaving ice...");
        Ingredient powderedMilk = new Ingredient("Powdered Milk", 2, 3, "Adding powdered milk...");

        Slot ShavedIce = new Slot("shaved Ice", shavedIce.getCalories(), shavedIce.getPrice());
        Slot PowderedMilk = new Slot("Powdered Milk", powderedMilk.getCalories(), powderedMilk.getPrice());

        this.specialInventory.add(ShavedIce);
        this.specialInventory.add(PowderedMilk);
        
        stockItem(shavedIce, 10);
        stockItem(powderedMilk, 10);
    }

    //prepare's order based on the currentOrder item list
    public ArrayList<String> prepareOrder() { 

        //LOGIC RESERVED FOR CONTROLLER
        ArrayList<String> result = new ArrayList<String>();
        if(!currentOrder.isEmpty()) {
            for(Item item : currentOrder) {
                if(item instanceof Ingredient) {
                    Ingredient i = (Ingredient)item;
                    result.add(i.getPreparationMsg());
                    currentOrder.remove(item);
                }
                totalCalories += item.getCalories(); //IDC ANYMORE
            }
        }

        return result;
    }

    public ArrayList<Slot> getSpecialInventory() {
        return this.specialInventory;
    }

    public ArrayList<Item> getCurrentOrder() {
        return this.currentOrder;
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    public void stockItem(Ingredient item, int amount){
        String itemName = item.getName().toLowerCase();

        for(Slot s : this.specialInventory){
            String slotName = s.getName().toLowerCase();

            if(slotName.equals(itemName)){
                s.addItem(item, amount);
                s.setInitQuantity(amount);
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
