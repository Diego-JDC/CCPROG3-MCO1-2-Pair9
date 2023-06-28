import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a vending machine factory.
 */

public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private String name;
    private Scanner scan = new Scanner(System.in); // I put the scanners here since there were problems with
                                                   // declaring new scanners every method

    /**
     * Constructor.
     * @param name Name of vending machine
     */
    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
        this.name = name;
    }

    /**
     * Adds a newly created vending machine to the machine list.
     * @param vm Vending machine object
     */

    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

    /**
     * Checks if the vending machine list is empty.
     * @return Boolean value
     */

    public boolean isVendingMachineListEmpty() {
        boolean result = false;
        if(vendingMachineList.isEmpty()) {
            result = true;
        } 
        return result;
    }

    /***
     * Function to make a new vending machine.
     * @param name Vending machine name
     */
    public void makeVendingMachine(String name) {
        VendingMachine n = new VendingMachine(name);
        vendingMachineList.add(n);
    }

    /**
     * Gets most recently created vending machine.
     * @return  Vending machine object
     */

    public VendingMachine getCurrentMachine(){
        int n = vendingMachineList.size();
        if(n != 0) {
            return vendingMachineList.get(n-1);
        }
        else{
            return null;
        }
    }

    /**
     * Tests the vending features of a given vending machine.
     * @param vm Vending machine object
     */

    public void testVendingFeatures(VendingMachine vm) {
        int choice;
        int transaction = 0; // stores the cash in machine during transaction.
        int cash = 0;
        int change = 0;
        String confirm = "n"; // confirms if user wants to proceed with transaction after inputting cash.
        boolean validConfirm = true;
        boolean validCash; // checks if cash input is valid

        System.out.println("=== TESTING VENDING FEATURES ===");
        System.out.println("Vending machine : \" " + vm.getName() +  " \" ");
        if(vm.getInventorySize() == 0){
            System.out.println("No items yet...");
        }

        else{
            vm.displayItems();
            do {
                System.out.print("Enter item by index [-1 to exit]: ");
                choice = scan.nextInt();
                if(choice < -1 || choice > vm.getInventorySize() - 1) {
                    System.out.println("Invalid choice!");
                }
            } while(choice < -1 || choice > vm.getInventorySize() - 1);

            //at this point, the user chose an item, or chose to exit
            if(choice != -1) {
                Item i = vm.getItem(choice);
                if(i.getQuantity() == 0) { // prints error if user chooses an item with 0 quantity.
                    System.out.println("Error : " + i.getName() + " is out of stock!");
                    choice = -1;
                }

                if(choice != -1){
                    do {
                        do {
                            System.out.println("You chose : " + vm.getItemName(choice));
                            System.out.println("Price : " + vm.getItemPrice(choice));
                            System.out.println("Cash in machine : " + transaction);
                            validCash = true;
                            System.out.println("Accepted inputs : [1, 5, 10, 20, 50, 100] PHP");
                            System.out.print("Input cash [0 to exit]: ");
                            cash = scan.nextInt();
                            if(cash != 0) { // makes sure not to print error if user wants to exit
                                if(!vm.isValidDenomination(cash) || cash < vm.getItemPrice(choice)) {
                                    System.out.println("Invalid cash input! \n");
                                    validCash = false;
                                }
                            }
                        } while(!vm.isValidDenomination(cash) && !validCash);

                        if(validCash && cash != 0){
                            // User can exit after putting in cash in case they change their mind
                            System.out.println("Proceed with transaction? [Y/N]");
                            scan.nextLine();
                            confirm = scan.nextLine();
                            validConfirm = true;

                            if(!(confirm.equals("Y")) && !(confirm.equals("N")) && !(confirm.equals("n")) && !(confirm.equals("y"))) {
                                System.out.println("Invalid input! Try again.");
                                validConfirm = false;
                            }

                            if(confirm.equals("y") || confirm.equals("Y")){
                                transaction += cash;
                                System.out.println();
                            }
                            else{
                                System.out.println("Returning money (" + cash + " PHP) to user");
                            }
                        }
                    } while(transaction < vm.getItemPrice(choice) && cash != 0 && !validConfirm); // loop won't exit until the user put enough money to pay for the item or they chose to exit.

                    //at this point, the money the user put in is enough to pay for the item or chose to exit.
                    if(validConfirm && (confirm.equals("Y") || confirm.equals("y"))){
                        if(cash != 0) {
                            System.out.println("Cash in machine : " + transaction); // just to let the user know how much they put in the machine as of this point.
                            if(transaction > vm.getItemPrice(choice)) { // machine needs to give change to the user
                                change = transaction - vm.getItemPrice(choice);
                                if(vm.updateBalance(change)) {//if the machine has enough balance to dispense change
                                    System.out.println("Machine has enough change!");
                                    System.out.println("Dispensing change : " + change + " PHP");
                                    System.out.println("Transaction success!");
                                    vm.addIncome(transaction - change); // add the transaction money to income
                                    System.out.println("Dispensing : " + vm.getItemName(choice));
                                    vm.updateStock(choice); // takes out 1 stock from the item
                                }
                                else {//the machine doesn't have enough balance to produce change
                                    System.out.println("Machine does not have enough change! Terminating transaction...");
                                    System.out.println("Returning money (" + transaction + " PHP) to user...");
                                }
                            }
                            else if(transaction == vm.getItemPrice(choice)) { // user put exact money to pay for the item, thus no change needed.
                                System.out.println("Transaction success!");
                                vm.addIncome(transaction); // add the transaction money to income
                                System.out.println("Dispensing : " + vm.getItemName(choice));
                                vm.updateStock(choice); // takes out 1 stock from the item
                            }
                        }
                    }
                }
            }
            System.out.println("Exiting Vending Feature testing...\n");
        }
    }

    /**
     * Edits different components of the vending machine.
     * @param vm Vending machine object
     */

    public void machineMaintenance(VendingMachine vm){
        int choice = 0;
        do {
            System.out.println("=== MAINTENANCE FEATURES ===");
            System.out.println("Name : " + vm.getName() + "\tBalance : " + vm.getBalance() + "\tIncome : " + vm.getIncome());
            System.out.println("[ 1 ] Add or Stock/Restock items");
            System.out.println("[ 2 ] Collect income");
            System.out.println("[ 3 ] Set item price");
            System.out.println("[ 4 ] Replenish system funds");
            System.out.println("[ 5 ] Print Transaction Summary");
            System.out.println("[ 6 ] Back to main menu");
            System.out.println("Enter choice: ");
            choice = scan.nextInt();

            if(choice > 6 || choice < 1) {
                System.out.println("Invalid input! Try again.");
            }

            //I moved the 'menu' methods here to encourage abstraction.
            switch(choice) {
                case 1 : stockUpMenu(vm);
                    break;
                case 2 : collectIncomeMenu(vm);
                    break;
                case 3 : setPriceMenu(vm);
                    break;
                case 4 : addBalanceMenu(vm);
                    break;
                case 5 : printTransactionSummary(vm);
            }

        } while(choice > 6 || choice < 1);
    }

    /**
     * Restocks or adds a particular item.
     * @param vm Vending machine object
     */

    public void stockUpMenu(VendingMachine vm) {
        int choice;
        boolean valid = false;
        do {
            do {
                System.out.println("Select option :");
                System.out.println("[ 1 ] Add items");
                System.out.println("[ 2 ] Restock existing items");
                System.out.println("[ 3 ] Back to previous menu");
                System.out.println("Enter choice : ");
                choice = scan.nextInt();

                if(choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Invalid input! Try again");
                }
            } while(choice != 1 && choice != 2 && choice != 3);

            if(choice == 1){
                if(vm.displayItems() <= vm.getItemCapacity()){
                    valid = true;
                }
            }

            //checks to make sure restocking already has existing items in inventory
            //regardless if their quantity is 0 or not
            if(choice == 2) {
                if(vm.getInventorySize() != 0) {
                    valid = true;
                }
                else {
                    System.out.println("Inventory is empty! Add items first.");
                }
            }
        } while(!valid);

        switch(choice) {
            // case 1 : adding items via maintenance mode
            case 1 : double calories;
                int price;
                String name;
                System.out.println("===ADDING A NEW ITEM===");
                do {
                    System.out.println("Enter item name : ");
                    scan.nextLine(); // Removes scanning error
                    name = scan.nextLine();
                    System.out.println("Enter calories : ");
                    calories = scan.nextDouble();
                    System.out.println("Enter price : ");
                    price = scan.nextInt();
                } while(!vm.addItem(name, calories, price));
                break;
            // case 2 : restocking previously added items via maintenance mode
            case 2 : int c, amount;
                System.out.println("===RESTOCKING ITEMS===");
                do {
                    System.out.print("\n");
                    System.out.println("------ITEM LIST------");
                    vm.displayItems();
                    do {
                        System.out.println("Enter index of your choice : ");
                        c = scan.nextInt();
                        if(c < 0 || c > vm.getInventorySize() - 1) {
                            System.out.println("Invalid index! Try again.");
                        }
                    } while (c < 0 || c > vm.getInventorySize() - 1);

                    System.out.println("Enter amount to add : ");
                    amount = scan.nextInt();
                } while(!vm.addItemQuantity(vm.getItem(c), amount));
                break;
        }
        System.out.println("Exiting Stock up menu... \n");
    }

    /**
     * Collects income gained from sales.
     * @param vm Vending machine object
     */

    public void collectIncomeMenu(VendingMachine vm) {
        String choice;
        System.out.println("Current Income is : " + vm.getIncome());
        do {
            System.out.println("Do you wish to collect it? [Y/N] ");
            scan.nextLine();
            choice = scan.nextLine(); // TODO : not really able to do y or n to exit the loop. (done)
            if(!(choice.equals("Y")) && !(choice.equals("N")) && !(choice.equals("n")) && !(choice.equals("y"))) {
                System.out.println("Invalid input! Try again.");
            }
        } while(!(choice.equals("Y")) && !(choice.equals("N")) && !(choice.equals("n")) && !(choice.equals("y")));

        if(choice.equals("Y") || choice.equals("y")) {
            System.out.println(vm.getIncome() + " PHP collected!");
            vm.setIncome(0);
        }
        //after this line, we're sure the user entered 'n'
        System.out.println("Exiting this menu...\n");
    }

    /**
     * Picks an item to set a new price in the menu.
     */

    public void setPriceMenu(VendingMachine vm) {
        if(vm.getInventorySize() != 0) {
            int index, newPrice = 0;
            boolean exit = false;
            System.out.println("===UPDATE ITEM PRICE===");
            System.out.println("------ITEM LIST------");
            vm.displayItems();
            do {
                System.out.println("Enter index of your choice (-1 to exit): ");
                index = scan.nextInt();

                if(index < 0){
                    exit = true;
                }

                else if(!exit && index > vm.getInventorySize() - 1){
                    System.out.println("Invalid index! Try again.");
                }

                if(!exit){
                    System.out.println("Enter new price : ");
                    newPrice = scan.nextInt();

                    if(newPrice < 0) {
                        System.out.println("Invalid price! Try again.");
                    }
                }
            } while (!exit && index > vm.getInventorySize() - 1 && newPrice < 0); //protecting user from invalid price & index.
            if(!exit){
                vm.setPrice(vm.getItem(index), newPrice);
            }
        }
        else {
            System.out.println("Inventory is empty! add items first.");
        }
    }

    /**
     * Adds machine balance.
     * @param vm Vending machine object
     */

    public void addBalanceMenu(VendingMachine vm) {
        Scanner scan = new Scanner(System.in);
        int addedBalance;
        do {
            System.out.print("Enter balance to add to machine : ");
            addedBalance = scan.nextInt();
            if(addedBalance < 0) {
                System.out.println("Invalid input! Try again.");
            }
        } while(addedBalance < 0);
        vm.addBalance(addedBalance);
        System.out.println("Added " + addedBalance + " PHP to balance.");
    }

    /**
     * Prints transaction summary based on initial quantity, current quantity, number of an item sold
     * and profit gained from selling each item.
     * @param vm Vending machine object
     */

    public void printTransactionSummary(VendingMachine vm) {

        if(vm.getInventorySize() > 0){
            System.out.println("\nPrinting Transaction Summary...");

            System.out.println("[ITEM NAME\t] : [INITIAL QUANTITY] : [# SOLD] : [CURRENT QUANTITY] : [PROFIT]");
            //some code to get the transaction summary
            for(Item i : vm.getInventory()) {
                System.out.println("[ " + i.getName() + "\t] : " + "[ " + i.getInitQuantity() + " ] : " +
                        "[ " + (i.getInitQuantity() - i.getQuantity()) + " ] : " + "[ " + i.getQuantity() + " ] : " +
                        "[ " + (i.getPrice() * (i.getInitQuantity() - i.getQuantity())) + " ]");
            }

            System.out.println("Done printing!\n");
        }
        else{
            System.out.println("No items in inventory yet!");
        }
    }
}
