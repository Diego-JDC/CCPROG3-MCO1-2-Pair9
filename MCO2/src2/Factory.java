
import java.util.ArrayList;

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private Menu menu;

    public Factory() {
        this.vendingMachineList = new ArrayList<VendingMachine>();
        if(!vendingMachineList.isEmpty()) {
            this.menu = new Menu(vendingMachineList.get(vendingMachineList.size() - 1));
        } else {
            this.menu = new Menu();
        }
        
    }

    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

    public ArrayList<VendingMachine> getVendingMachineList() {
        return vendingMachineList;
    }

    public Menu getMenu() {
        return this.menu;
    }
}
