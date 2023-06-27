import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a vending machine factory.
 */

 //PLEASE DO NOT CLOSE THE SCANNERS THEY WILL CAUSE AN ERROR IF YOU CLOSE ANY SCANNERS HERE.
public class Factory {
    private ArrayList<VendingMachine> vendingMachineList;
    private String name;

    public Factory(String name) {
        this.vendingMachineList = new ArrayList<VendingMachine>();
        this.name = name;
    }


    public void addToVendingMachineList(VendingMachine vm) {
        vendingMachineList.add(vm);
    }

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

    public void testVendingFeatures(VendingMachine vm) {
        Scanner scan = new Scanner(System.in);
        int choice;
        int transaction = 0; // stores the cash in machine during transaction.
        int cash = 0;
        int change = 0;

        System.out.println("=== TESTING VENDING FEATURES ===");
        System.out.println("Vending machine : \" " + vm.getName() +  " \" ");
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
                System.out.println("Error : " + i.getName() + " has 0 quantity!");
                choice = -1;
            }

            do {
                System.out.println("You chose : " + vm.getItemName(choice));
                System.out.println("Price : " + vm.getItemPrice(choice));
                System.out.println("Cash in machine : " + transaction);
                do {
                    System.out.println("Accepted inputs : [1, 5, 10, 20, 50, 100] PHP");
                    System.out.print("Input cash [0 to exit]: ");
                    cash = scan.nextInt();
                    if(cash != 0) { // makes sure not to print error if user wants to exit
                        if(vm.isValidDenomination(cash) == false) {
                            System.out.println("Invalid cash input! \n");
                        }
                    }
                } while(vm.isValidDenomination(cash) == false && cash != 0);
                transaction += cash;
                System.out.println();
            } while(transaction < vm.getItemPrice(choice) && cash != 0); // loop won't exit until the user put enough money to pay for the item or they chose to exit.

            //at this point, the money the user put in is enough to pay for the item or chose to exit.
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
        System.out.println("Exiting Vending Feature testing...\n");
        //scan.close();
    }

    /**
     * Tests vending features.
     */
    //we can remove this.
    public void testVendingFeatures(){
        System.out.println("=== TESTING VENDING FEATURES ===");
        VendingMachine machine = getCurrentMachine(); // I think its better to use this in main when passing a vending machine object to this function
        Scanner sc = new Scanner(System.in);

        // Gets item choice and input cash of user
        int choice;
        int moneyInput;
        int itemNum;
        boolean valid = false;
        int confirm;

        //makes sure the vendingmachinglist is not empty
        if(vendingMachineList.size() > 0 && machine.getInventorySize() != 0){
            itemNum = machine.displayItems();
            System.out.println("Select item: ");
            choice = sc.nextInt();
            System.out.println("[Accepted inputs: 1, 5, 10, 20, 50, 100 PHP]");
            // BEFORE READING THIS PSUEDOCODE : I already implemented it in the method above. Feel free to use the pseudocode below as a reference for the method above this method.
            //we should simulate how you would input or put your cash in an IRL vending machine
            //for payment "()" are the program processes in pseudocode after user input
            //EXAMPLE : I picked an item that costs 150
            //  PROGRAM OUTPUT --
            //      You chose <item the user chose>
            //      Item Price : 150
            //      Cash in machine : 0 [because the user hasn't put in cash in the machine yet]
            //      Input Cash : 100 <-[user inputs 100 as in 100PHP] [USER PRESSES ENTER]
            //          (program checks that the input is valid, that is if its part of the denominations and it is)
            //              (if its not valid, then print error message and go back to line 74)
            //          (program checks if cash in machine (it is now 100 PHP after line 74) is >= item price)
            //              (in this case it's not, so print "Item Price : etc." again.)
            //
            //      You chose <item the user chose>
            //      Item Price : 150
            //      Cash in machine : 100 (updated to 100 because the user put in a 100 php bill)
            //      Input cash : 100 <-[user inputs 100] [USER PRESSES ENTER]
            //          (program check that the input is valid, and it is, so the cash in machine for the transaction is 200 PHP)
            //              (if its not valid, then print error message and go back to line 81)
            //          (since the cash in machine (payment) for this transaction is >= item price)
            //              (if the balance has enough for change (balance >= payment))
            //                  (if greater than item price)
            //                      (take change and subtract from balance and output change thru print)
            //                  (if equal to item price)
            //                      (nothing is taken from balance and just output with change outputted : 0)
            //              (else the machine can't produce enough change for the transaction)
            //                  (program prints error that machine doesn't have enough change, terminate transaction.)
            //
            //      Transaction successful! Dispensing <item>
            //      Dispensing change : 50 PHP [because the user put in 200 PHP so 200 - 150 = 50]
            //          (program adds 150 to income)
            //
            //END OF EXAMPLE
            // NOTE : We should also add an option for the user to quit in the middle
            // of a transaction, let's say we run thru the EXAMPLE up until line 83, 
            // but at this point I changed my mind and want to get a diff item.
            // We should let the user input -1 or 0 as an 'exit' to the transaction.
            // If the user chooses to exit in the middle of a transaction, then
            // we print something like "<cash in machine> returned"
            do{
                System.out.print("Input cash: ");
                moneyInput = sc.nextInt();
                //TODO print smth to let user know they inputted invalid inputs
            }while(!machine.isValidDenomination(moneyInput));

            System.out.print("Proceed with transaction? [1]Yes [2]No");
            confirm = sc.nextInt();

            if(confirm == 1){
                // Checks if the transaction can push through
                valid = machine.isValidTransaction(choice-1, moneyInput, itemNum);
                if(valid){
                    System.out.println("Valid. (nothing here yet)");
                }
                else{
                    System.out.println("Error in transaction. Please try again later.");
                }
            }
            else{
                System.out.println("Transaction cancelled. Returning " + moneyInput + " PHP");
            }
        }

        else if(vendingMachineList.size() == 0){
            System.out.println("There are no vending machines created yet.");
            System.out.println("Press any key to continue...");
            sc.next();
        }

        else if(machine.getInventorySize() == 0){
            System.out.println("There are no items in the vending machine yet.");
            System.out.println("Press any key to continue...");
            sc.next();
        }
    }

    /**
     * Edits components of the vending machine.
     * @param vm Vending machine object
     */

    public void machineMaintenance(VendingMachine vm){
        Scanner scan = new Scanner(System.in);
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
        //scan.close();
    }

    /**
     * Restocks or adds items.
     */

    public void stockUpMenu(VendingMachine vm) {
        Scanner scan = new Scanner(System.in);
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
                        if(c < 0 || c >= vm.getInventorySize() - 1) {
                            System.out.println("Invalid index! Try again.");
                        }
                    } while (c < 0 || c >= vm.getInventorySize() - 1);

                    System.out.println("Enter amount to add : ");
                    amount = scan.nextInt();
                } while(!vm.addItemQuantity(vm.getItem(c), amount));
                break;
        }
        System.out.println("Exiting Stock up menu... \n");
        //scan.close();
    }

    public void collectIncomeMenu(VendingMachine vm) {
        Scanner scan = new Scanner(System.in);
        String choice;
        System.out.println("Current Income is : " + vm.getIncome());
        do {
            System.out.print("Do you wish to collect it? [y/n] ");
            choice = scan.nextLine(); // TODO : not really able to do y or n to exit the loop.
            if(choice != "y" || choice != "n") {
                System.out.println("Invalid input! Try again.");
            }
        } while(choice != "y" || choice != "n");

        if(choice == "y") {
            System.out.println(vm.getIncome() + " PHP collected!");
            vm.setIncome(0); 
        }
        //after this line, we're sure the user entered 'n'
        System.out.println("Exiting this menu...\n");
        //scan.close();
    }

    /**
     * Picks an item to set a new price in the menu.
     */

    public void setPriceMenu(VendingMachine vm) {
        
        if(vm.getInventorySize() != 0) {
            Scanner scan = new Scanner(System.in);
            int index, newPrice;
            System.out.println("===UPDATE ITEM PRICE===");
            System.out.println("------ITEM LIST------");
            vm.displayItems();
            do {
                System.out.println("Enter index of your choice : ");
                index = scan.nextInt();

                System.out.println("Enter new price : ");
                newPrice = scan.nextInt();

                if(index < 0 || index >= vm.getInventorySize() - 1) {
                    System.out.println("Invalid index! Try again.");
                }
                if(newPrice < 0) {
                    System.out.println("Invalid price! Try again.");
                }

            } while (index < 0 || index >= vm.getInventorySize() - 1 || newPrice < 0); //protecting user from invalid price & index.
            vm.setPrice(vm.getItem(index), newPrice);

            //scan.close();
        }
        else {
            System.out.println("Inventory is empty! add items first.");
        }

    }

    public void addBalanceMenu(VendingMachine vm) {
        Scanner scan = new Scanner(System.in);
        int addedBalance;
        do {
            System.out.print("Enter balance to add to machine : ");
            addedBalance = scan.nextInt();
            if(addedBalance < 0) {
                System.out.println("Invlid input! Try again.");
            }
        } while(addedBalance < 0);
        vm.addBalance(addedBalance);
        System.out.println("Added " + addedBalance + " PHP to balance.");
        //scan.close();
    }

    public void printTransactionSummary(VendingMachine vm) {
        System.out.println("\nPrinting Transaction Summary...");

        System.out.println("[ITEM NAME\t] : [INITIAL QUANTITY] : [# SOLD] : [CURRENT QUANTITY] : [PROFIT]");
        //some code to get the transaction summary
        for(Item i : vm.getInventory()) {
            System.out.println("[ " + i.getName() + "\t] : " + "[ " + i.getInitQuantity() + " ] : " + "[ " + (i.getInitQuantity() - i.getQuantity()) + " ] : " + "[ " + i.getQuantity() + " ] : " + "[ " + (i.getPrice() * (i.getInitQuantity() - i.getQuantity())) + " ]");
        }

        System.out.println("Done printing!\n");
    }

    
}
