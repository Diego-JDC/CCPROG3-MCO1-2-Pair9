
import java.util.ArrayList;

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;

    public Factory() {
        this.vendingMachineList = new ArrayList<VendingMachine>();
    }

    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

    public ArrayList<VendingMachine> getVendingMachineList() {
        return vendingMachineList;
    }

}
