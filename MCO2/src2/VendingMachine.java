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

    //TEMPORARY
    public void addSlot(String name) {
        Slot n = new Slot(name);
        this.inventory.add(n);
    }

    public void stockItem(Item item, int amount){
        String itemName = item.getName().toLowerCase();

        for(Slot s : this.inventory){
            String slotName = s.getName().toLowerCase();

            if(slotName.equals(itemName)){
                s.addItem(item, amount);
                s.setInitQuantity(amount);
            }
        }
    }

    //TEMPORARY
    public void displayInventory() {
        int index = 0;
        for(Slot s : this.inventory) {
            System.out.println(index + " " + s.getName() + " stock: " + s.getItemList().size());
        }
    }

    //TEMPORARY
    public void removeSlot(String name) {
        for(Slot s : inventory) {
            if(s.getName() == name) {
                inventory.remove(s);
            }
        }
    }

    //TEMPORARY
    public void removeSlot(Slot s) {
        inventory.remove(s);
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
}
