import java.util.ArrayList;

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;

    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
    }

    public void makeVendingMachine(String name) {
        VendingMachine n = new VendingMachine(name);
        vendingMachineList.add(n);
    }
    
    public void makeVendingMachine(String name, double startingBalance) {
        VendingMachine n = new VendingMachine(name, startingBalance);
        vendingMachineList.add(n);
    }

}
