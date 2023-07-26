package MCO2.src2;

import java.util.ArrayList;

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private Menu menu;

    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
        this.menu = new Menu();
    }

    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

    public ArrayList<VendingMachine> getVendingMachineList() {
        return vendingMachineList;
    }

    public Menu getMenu() {
        return menu;
    }
}
