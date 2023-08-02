
import java.util.ArrayList;

/**
 * Factory class that creates vending machine objects
 */

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;

    /**
     * Constructor
     */

    public Factory() {
        this.vendingMachineList = new ArrayList<VendingMachine>();
    }

    /**
     * Adds a vending machine object to the list of vending machines
     * @param vm vending machine object
     */

    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

    /**
     * Gets the vending machine list
     * @return ArrayList of vending machines
     */

    public ArrayList<VendingMachine> getVendingMachineList() {
        return vendingMachineList;
    }

}
