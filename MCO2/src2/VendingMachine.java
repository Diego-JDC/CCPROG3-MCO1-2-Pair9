import java.util.ArrayList;

public class VendingMachine {
    private String name;
    private ArrayList<Slot> inventory;
    private int change;
    private int income;
    
    public VendingMachine(String name) {
        this.name = name;
        this.inventory = new ArrayList<Slot>();
        this.change = 0;
        this.income = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getChange() {
        return this.change;
    }

    public int getIncome() {
        return this.income;
    }

    public ArrayList<Slot> getInventory() {
        return this.inventory;
    }
    
    public void setChange(int amount) {
        this.change += amount;
    }

    public void setIncome(int amount) {
        this.income = amount;
    }

    public void addSlot(Slot s) {
        this.inventory.add(s);
    }

    public void stockItem(Item item, int amount){
        String itemName = item.getName().toLowerCase();

        for(Slot s : this.inventory){
            String slotName = s.getName().toLowerCase();

            if(slotName.equals(itemName)){
                s.addItem(item, amount);
                s.setInitQuantity(amount - 1);
            }
        }
    }

    public boolean isValidDenomination(int input){
        int[] validInputs = new int[] {1, 5, 10, 20, 50, 100};
        boolean valid = false;

        for(int i : validInputs){
            if(i == input){
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Checks if every slot in inventory is empty (no more item instances in it)
     * @return boolean value. True is the inventory has slots but is all out of stock, otherwise return false
     */
    public boolean isAllOutOfStock() {
        boolean result = true;
        for(Slot s : inventory) {
            if(!s.getItemList().isEmpty()) {
                result = false;
            }
        }
        return result;
    }
}
