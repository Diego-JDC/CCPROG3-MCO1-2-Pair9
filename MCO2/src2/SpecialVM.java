import java.util.ArrayList;

public class SpecialVM extends VendingMachine {
    private ArrayList<Slot> specialInventory;
    private ArrayList<Item> currentOrder;
    private double totalCalories;

    //order of operations for ingredient preparation
    //checks based on name/type (type is aaplicable)
    private String[] ingredientOrder = {"Shaved Ice","Powdered Milk", 
                                         "Extract", "Food Color", "Topping"};

    public SpecialVM(String name) {
        super(name);
        this.specialInventory = new ArrayList<Slot>();
        this.currentOrder = new ArrayList<Item>();
        this.totalCalories = 0;

        Item shavedIce = new Item("Shaved Ice", 0, 10);
        Item powderedMilk = new Item("Powdered Milk", 2, 3);

        specialInventory.add(new Slot("Shaved Ice"));
        specialInventory.add(new Slot("Powdered Milk"));
        super.stockItem(shavedIce, 10);
        super.stockItem(powderedMilk, 10);
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
}
