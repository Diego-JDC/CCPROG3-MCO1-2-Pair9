import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JRadioButton;

/**
 * Controller for MVC structure
 */

public class Controller {
    private ViewMenu view;
    private Factory factory;
    private VendingMachine vm;
    String VMNameHolder = "Vending Machine: ";
    String VMTypeHolder = "Type: ";
    int currentTransaction;
    String currentItem;
    ArrayList<String> typesOfIng;
    String typeSelected;

    public Controller(ViewMenu view, Factory factory){
        this.view = view;
        this.factory = factory;
        this.vm = factory.getVendingMachineList().get(factory.getVendingMachineList().size() - 1);
        this.currentTransaction = 0;
        this.currentItem = new String();
        this.typesOfIng = new ArrayList<String>() {
            {
                add("Topping");
                add("Powdered Topping");
                add("Food Color");
                add("Flavor Extract");
            }
        };
        
        // Adds actionlistneer to "create" button
        //CREATE VENDING MACHINE
        this.view.setCreateBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Creates a new JFrame/window
                CreateMenu cMenu = new CreateMenu();
                cMenu.setVisible(true);
                cMenu.hideOptions();
                cMenu.hideErrMsg();
                view.setEnabled(false);

                cMenu.setBack(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        view.setEnabled(true);
                        cMenu.dispose();
                    }
                });

                cMenu.setSubmitBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String name = cMenu.getName();

                        if(name.length() > 10 || name.length() == 0){
                            do{
                                if(name.length() > 10) {
                                    cMenu.setErrMsg("Name is too long! Try again.");
                                } else if(name.length() == 0) {
                                    cMenu.setErrMsg("Input name first!");
                                }
                                
                                cMenu.resetTextField();
                                name = cMenu.getName();
                            }while(name.length() > 10);
                        }

                        else{
                            cMenu.showOptions();
                            cMenu.setErrMsg("");
                            cMenu.setRegularBtn(new ActionListener() {
                                public void actionPerformed(ActionEvent e){
                                    String name = cMenu.getName();
                                    cMenu.setMessage(name, "regular vending machine");
                                    VendingMachine nVM = new VendingMachine(name);
                                    factory.addToVendingMachineList(nVM);
                                }
                            });
    
                            cMenu.setSpecBtn(new ActionListener() {
                                public void actionPerformed(ActionEvent e){
                                    String name = cMenu.getName();
                                    cMenu.setMessage(name, "special vending machine");
                                    VendingMachine svm = new SpecialVM(name);
                                    factory.addToVendingMachineList(svm);
                                }
                            });
                        }
                    }
                });
            }
        });

        //MAINTENANCE ON CURRENT MACHINE
        this.view.setMaintenanceBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MaintenanceMenu mMenu = new MaintenanceMenu();
                ArrayList<VendingMachine> currentList = factory.getVendingMachineList();
                VendingMachine vm = currentList.get(currentList.size()-1);

                view.setEnabled(false);
                mMenu.setIncomeLabel(vm.getIncome());
                mMenu.setChangeLabel(vm.getChange());
                mMenu.hideAll();
                mMenu.resetList();

                //BACK BUTTON
                mMenu.setBack(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        view.setEnabled(true);
                        mMenu.dispose();
                    }
                });

                //SET ITEM PRICE
                mMenu.setPriceBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        ArrayList<Slot> list = vm.getInventory();
                        ArrayList<Slot> allItems = new ArrayList<Slot>();
                        
                        for(Slot s : list){
                            allItems.add(s);
                        }

                        mMenu.hideAll();

                        if(vm instanceof SpecialVM){
                            for(Slot s : ((SpecialVM)vm).getSpecialInventory()){
                                allItems.add(s);
                            }
                        }

                        mMenu.setItemList(allItems);
                        mMenu.showPriceMenu();

                        Slot s = mMenu.getSelected();
                        mMenu.setPriceLabel(s.getItemPrice());

                        mMenu.setItemListBtn(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                Slot s = mMenu.getSelected();
                                mMenu.setPriceLabel(s.getItemPrice());
                            }
                        });

                        mMenu.setSubmitBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int input = mMenu.getInput();
                                Slot s = mMenu.getSelected();
                                s.setItemPrice(input);
                                mMenu.setPriceLabel(s.getItemPrice());
                                mMenu.clearField();
                            }
                        });
                    }
                });
                
                //REPLENISH CHANGE
                mMenu.setReplenishBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        mMenu.hideAll();
                        mMenu.showReplenish();
                        mMenu.setChangeBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                int amount = mMenu.getReplenishAmt();
                                vm.setChange(amount);
                                mMenu.setChangeLabel(vm.getChange());
                            }
                        });
                    }
                });

                //COLLECT INCOME
                mMenu.setCollectBtn(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        mMenu.hideAll();
                        mMenu.hideCollectMsg();
                        mMenu.showCollect();
                        mMenu.collectedIncomeLabel(vm.getIncome());
                        mMenu.setConfirm(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                mMenu.collectedAmt(vm.getIncome());
                                vm.setIncome(0);
                                mMenu.collectedIncomeLabel(vm.getIncome());
                                mMenu.setCurrentIncome(vm.getIncome());
                            }
                        });
                    }
                });

                //TRANSACTIONS SUMMARY
                
                mMenu.setSummaryBtn(new ActionListener() {
                    boolean pressedBtn = false; // so that the table gets set up only ONCE
                    public void actionPerformed(ActionEvent e){
                        if(!pressedBtn) {
                            mMenu.setTable(vm);
                            pressedBtn = true;
                        }
                        mMenu.hideAll();
                        mMenu.showTransactionMenu();
                    }
                });
                mMenu.setVisible(true);

                mMenu.setAddBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        mMenu.showAddMenuOptions();
                        JRadioButton ingBtn = mMenu.getIngBtn();
                        JRadioButton regBtn = mMenu.getRegBtn();
                        ingBtn.setVisible(false);
                        regBtn.setVisible(false);

                        mMenu.setOptionAddBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                mMenu.showAddItemsMenu();
                                mMenu.getTypeList().setVisible(false);
                                mMenu.getTypeLbl().setVisible(false);
                                

                                if(vm instanceof SpecialVM){
                                    ingBtn.setVisible(true);
                                    regBtn.setVisible(true);
                                }

                                mMenu.setIngBtn(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        if(ingBtn.isSelected()) {
                                            mMenu.setTypeList(typesOfIng);
                                            mMenu.getTypeList().setVisible(true);
                                            mMenu.getTypeLbl().setVisible(true);
                                            mMenu.setTypeListAL(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    typeSelected = mMenu.getTypeSelected();
                                                }
                                            });
                                        } else {
                                            mMenu.getTypeList().setVisible(false);
                                            mMenu.getTypeLbl().setVisible(false);
                                        }
                                    }
                                });

                                mMenu.setAddItemBtn(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        mMenu.hideAddMessage();
                                        Slot slot = new Slot(mMenu.getNewItemName(), mMenu.getNewCalories(), mMenu.getNewPrice());
                                        if(vm instanceof SpecialVM){
                                            if(ingBtn.isSelected()){
                                                Ingredient ing = new Ingredient(mMenu.getNewItemName(), 
                                                mMenu.getNewCalories(), mMenu.getNewPrice(), 
                                                "Adding " + mMenu.getNewItemName() + " to Ice Scramble...", typeSelected); // TYPE DEPENDING ON COMBO BOX CHOICE
                                                slot.addItem(ing); // might have to change this at some point
                                                slot.setInitQuantity(0);
                                                ((SpecialVM)vm).getSpecialInventory().add(slot);
                                            }
                                            else if(regBtn.isSelected()){
                                                Item item = new Item(mMenu.getNewItemName(), mMenu.getNewCalories(), mMenu.getNewPrice());
                                                slot.setInitQuantity(0);
                                                slot.addItem(item);
                                                vm.getInventory().add(slot);
                                            }
                                            else if(regBtn.isSelected() && ingBtn.isSelected()){
                                                Ingredient ing = new Ingredient(mMenu.getNewItemName(), 
                                                mMenu.getNewCalories(), mMenu.getNewPrice(), 
                                                "Adding " + mMenu.getNewItemName() + " to Ice Scramble...", typeSelected);
                                                slot.setInitQuantity(0);
                                                slot.addItem(ing);
                                                vm.getInventory().add(slot);
                                                ((SpecialVM)vm).getSpecialInventory().add(slot);
                                            } else {
                                                System.out.println("Could not add item!");
                                            }
                                        }
                                        else{
                                            Item item = new Item(mMenu.getNewItemName(), mMenu.getNewCalories(), mMenu.getNewPrice());
                                            slot.setInitQuantity(0);
                                            slot.addItem(item);
                                            vm.getInventory().add(slot);
                                        }
                                        mMenu.resetAddItemFields();
                                        mMenu.showAddMessage();
                                    }
                                });
                            }
                        });
                    
                        mMenu.setOptionRestockBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                ArrayList<Slot> list = vm.getInventory();
                                ArrayList<Slot> allItems = new ArrayList<Slot>();
                                
                                for(Slot s : list){
                                    allItems.add(s);
                                }

                                if(vm instanceof SpecialVM){
                                    for(Slot s : ((SpecialVM)vm).getSpecialInventory()){
                                        allItems.add(s);
                                    }
                                }
                                mMenu.setRestockItemList(allItems);
                                mMenu.showRestockMenu();

                                Slot s = mMenu.getSelectedRestock();
                                ArrayList<Item> currList = s.getItemList();
                                mMenu.setCurrentStock(currList.size() - 1);

                                mMenu.setRestockList(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        Slot s = mMenu.getSelectedRestock();
                                        ArrayList<Item> currList = s.getItemList();
                                        mMenu.setCurrentStock(currList.size() - 1);
                                    }
                                });

                                mMenu.setRestockBtn(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        Slot s = mMenu.getSelectedRestock();
                                        ArrayList<Item> currList = s.getItemList();
                                        s.setInitQuantity(currList.size() - 1 + mMenu.getInputStock());
                                        s.addItem(s.getItemList().get(0), mMenu.getInputStock());
                                        mMenu.setCurrentStock(currList.size() - 1);
                                        mMenu.clearStockField();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //TEST CURRENT MACHINE
        this.view.setFeaturesBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                FeaturesMenu fMenu = new FeaturesMenu();
                
                fMenu.getSpecMenuBtn().setVisible(false);

                fMenu.hideBuyingFunction();
                fMenu.getChangeField().setVisible(false);
                fMenu.updateSelect("None");

                ArrayList<VendingMachine> currentList = factory.getVendingMachineList();
                VendingMachine vm = currentList.get(currentList.size()-1);

                fMenu.setVendingMachineName(VMNameHolder + vm.getName());
                if(vm instanceof SpecialVM) {
                    fMenu.setType(VMTypeHolder + "Special");
                    fMenu.getSpecMenuBtn().setVisible(true);
                } else {
                    fMenu.setType(VMTypeHolder + "Regular");
                }

                fMenu.getEmptyLbl().setVisible(false);
                if(vm.getInventory().isEmpty()) {
                    fMenu.getEmptyLbl().setVisible(true);
                } else if(vm.isAllOutOfStock()) {
                    fMenu.getEmptyLbl().setText("All out of stock...");
                }
                
                fMenu.setBack(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        view.setEnabled(true);
                        fMenu.dispose();
                    }
                });

                fMenu.setTable(vm);
                fMenu.hideTransLabel();

                fMenu.setSelectBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String name = fMenu.getRow();
                        for(Slot s : vm.getInventory()){
                            if(s.getItemList().size() - 1 != 0) {
                                if(name.equals(s.getName())) {
                                    currentItem = s.getName();
                                    fMenu.updateSelect(s.getName());
                                    fMenu.showBuyingFunction();
                                    fMenu.getChangeField().setVisible(true);
                                    if(currentTransaction > 0) {
                                        fMenu.setDispenseLbl("Returned " + currentTransaction + ".00 PHP");
                                        currentTransaction = 0;
                                        fMenu.updateTransLabel(currentTransaction);
                                        fMenu.getCashFieldTF().setText("");
                                    } else {
                                        fMenu.setDispenseLbl("");
                                        fMenu.setChangeLbl("");
                                        fMenu.getCashFieldTF().setText("");
                                    }

                                    break;
                                }
                            } else {
                                fMenu.hideBuyingFunction();
                                fMenu.getChangeField().setVisible(false);
                                fMenu.setDispenseLbl(s.getName() + " is out of stock!");
                            }
                            
                        }
                    }
                });

                fMenu.setInsertBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if(vm.isValidDenomination(fMenu.getCashField())){
                            currentTransaction += fMenu.getCashField();
                            fMenu.updateTransLabel(currentTransaction);
                            fMenu.getCashFieldTF().setText("");
                        }
                        else{
                            fMenu.errorTransLabel();
                        }
                    }
                });

                fMenu.setCancelBtn(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {

                        fMenu.hideBuyingFunction();
                        fMenu.getChangeField().setVisible(false);
                        fMenu.updateSelect("None");
                        if(currentTransaction > 0) {
                            fMenu.setDispenseLbl("Returned " + currentTransaction + ".00 PHP");
                            currentTransaction = 0;
                            fMenu.updateTransLabel(currentTransaction);
                            fMenu.getCashFieldTF().setText("");
                        } else {
                            fMenu.getCashFieldTF().setText("");
                            fMenu.setDispenseLbl("");
                            fMenu.setChangeLbl("");
                        }
                   } 
                });

                fMenu.setBuyBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        for(Slot s : vm.getInventory()) {
                            if(currentItem.equals(s.getName())) {
                                if(currentTransaction >= s.getItemPrice()) {
                                    fMenu.getCashFieldTF().setText("");
                                    int change = currentTransaction - s.getItemPrice();
                                    int profit = currentTransaction - change;
                                    fMenu.setChangeLbl(Integer.toString(change) + ".00 PHP");
                                    vm.setIncome(vm.getIncome() + profit);
                                    fMenu.hideBuyingFunction();
                                    fMenu.getChangeField().setVisible(true);
                                    fMenu.updateSelect("None");
                                    fMenu.setDispenseLbl("Success! Dispensing: " + s.getName());
                                    s.getItemList().remove(0);
                                    currentTransaction = 0;
                                    fMenu.updateTransLabel(currentTransaction);
                                } else {
                                    fMenu.setDispenseLbl("Not enough funds!");
                                }
                                fMenu.removeTable();
                                fMenu.setTable(vm);
                                break;
                            }
                        }
                        
                    }
                });

                //SPECIAL MENU FOR ICE SCRAMBLE MAKING
                fMenu.setSpecBtn(new ActionListener() {
                    Slot currColor;
                    Slot currFlavor;
                    Slot currPTopping;
                    Slot currTopping;
                    int totalPrice = 0;
                    int totalCalories = 0;
                    String fullPrepMsg = new String();
                    boolean confirmedSelection = false;
                    int currentTransaction = 0;
                    boolean orderComplete = false;
                    boolean invalid = false;
                    public void actionPerformed(ActionEvent e){
                        SpecMenu sMenu = new SpecMenu();
                        fMenu.dispose();
                        sMenu.setVisible(true);

                        sMenu.setColorBoxList(((SpecialVM)vm).getSpecialInventory());
                        sMenu.setFlavorBoxList(((SpecialVM)vm).getSpecialInventory());
                        sMenu.setPToppingBoxList(((SpecialVM)vm).getSpecialInventory());
                        sMenu.setToppingList(((SpecialVM)vm).getSpecialInventory());

                        sMenu.getChangeTF().setText("Change:");

                        sMenu.setBack(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                sMenu.dispose();
                                view.setEnabled(true);
                            }
                        });

                        sMenu.setColorBox(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(sMenu.getColorBox().getSelectedItem().equals("None")) {
                                    sMenu.getColorStock().setText("");
                                    currColor = null;
                                }
                                for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                    if(s.getName().equals(sMenu.getColorBox().getSelectedItem())) {
                                        sMenu.getColorStock().setText(Integer.toString(s.getItemList().size() - 1) + "(" + s.getPrice() + " PHP)");
                                        currColor = s;
                                    }
                                }
                            }
                        });

                        sMenu.setFlavorBox(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(sMenu.getFlavorBox().getSelectedItem().equals("None")) {
                                    sMenu.getFlavorStock().setText("");
                                    currFlavor = null;
                                }
                                for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                    if(s.getName().equals(sMenu.getFlavorBox().getSelectedItem())) {
                                        sMenu.getFlavorStock().setText(Integer.toString(s.getItemList().size() - 1) + "(" + s.getPrice() + " PHP)");
                                        currFlavor = s;
                                    }
                                }
                            }
                        });

                        sMenu.setPToppingBox(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(sMenu.getPToppingBox().getSelectedItem().equals("None")) {
                                    sMenu.getPToppingStock().setText("");
                                    currPTopping = null;
                                }
                                for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                    if(s.getName().equals(sMenu.getPToppingBox().getSelectedItem())) {
                                        sMenu.getPToppingStock().setText(Integer.toString(s.getItemList().size() - 1) + "(" + s.getPrice() + " PHP)");
                                        currPTopping = s;
                                    }
                                }
                            }
                        });

                        sMenu.setToppingBox(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                
                                if(sMenu.getToppingBox().getSelectedItem().equals("None")) {
                                    sMenu.getToppingStock().setText("");
                                    currTopping = null;
                                }
                                for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                    if(s.getName().equals(sMenu.getToppingBox().getSelectedItem())) {
                                        sMenu.getToppingStock().setText(Integer.toString(s.getItemList().size() - 1) + "(" + s.getPrice() + " PHP)");
                                        currTopping = s;
                                    }
                                }
                            }
                        });

                        sMenu.setConfirmBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(!confirmedSelection) {
                                    if(sMenu.getFlavorBox().getSelectedItem().equals("None")) {
                                        sMenu.getSpecMsgLbl().setText("Choose a flavor first!");
                                    } else {
                                        for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                            if(s.equals(currColor)) {
                                                if(s.getItemList().size() - 1 != 0) {
                                                    totalPrice += s.getPrice();
                                                    totalCalories += s.getCalories();
                                                } else {
                                                    invalid = true;
                                                }
                                            }
                                            if(s.equals(currFlavor)) {
                                                if(s.getItemList().size() - 1 != 0) {
                                                    totalPrice += s.getPrice();
                                                    totalCalories += s.getCalories();
                                                } else {
                                                    invalid = true;
                                                }
                                            }
                                            if(s.equals(currPTopping)) {
                                                if(s.getItemList().size() - 1 != 0) {
                                                    totalPrice += s.getPrice();
                                                    totalCalories += s.getCalories();
                                                } else {
                                                    invalid = true;
                                                }
                                            }
                                            if(s.equals(currTopping)) {
                                                if(s.getItemList().size() - 1 != 0) {
                                                    totalPrice += s.getPrice();
                                                    totalCalories += s.getCalories();
                                                } else {
                                                    invalid = true;
                                                }
                                            }
                                            if(s.getName().equals("Shaved Ice")) {
                                                if(s.getItemList().size() - 1 == 0) {
                                                    sMenu.getSpecMsgLbl().setText("Ran out of shaved ice! Restock needed");
                                                    orderComplete = false;
                                                } else {
                                                    totalPrice += s.getPrice();
                                                    totalCalories += s.getCalories();
                                                    orderComplete = true;
                                                }
                                            }
                                        }
                                        if(orderComplete && !invalid) {
                                            sMenu.getSpecMsgLbl().setText("Success! Order Price: " + totalPrice + " PHP");
                                            confirmedSelection = true;

                                            sMenu.getTransLbl().setText("");
                                            sMenu.getStatusLbl().setText("");
                                            sMenu.getChangeTF().setText("Change:");
                                        } else if(invalid) {
                                            sMenu.getSpecMsgLbl().setText("Invalid Selection!");
                                        }
                                    }
                                } else {
                                    sMenu.getSpecMsgLbl().setText("Press Cancel to redo order!");
                                }
                            }
                        });

                        sMenu.setInsertBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(confirmedSelection) {
                                    if(vm.isValidDenomination(Integer.parseInt(sMenu.getCashField().getText()))) {
                                        currentTransaction += Integer.parseInt(sMenu.getCashField().getText());
                                        sMenu.getTransLbl().setText("Inserted: " + currentTransaction + " PHP");
                                        sMenu.getCashField().setText("");
                                    } else {
                                        sMenu.getTransLbl().setText("Invalid Denomination!");
                                        sMenu.getCashField().setText("");
                                    }
                                } else {
                                    sMenu.getTransLbl().setText("Select ingredients first!");
                                    sMenu.getCashField().setText("");
                                }
                            }
                        });

                        sMenu.setBuyBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(confirmedSelection) {
                                    if(currentTransaction >= totalPrice) {
                                        sMenu.getChangeTF().setText("Change: " + (currentTransaction - totalPrice) + " PHP");
                                        vm.setIncome(vm.getIncome() + totalPrice);
                                        if(currColor != null && currColor.getItemList().size()-1 == 0) {
                                            currColor.getItemList().remove(1);
                                        }
                                        if(currFlavor != null && currFlavor.getItemList().size()-1 == 0) {
                                            currFlavor.getItemList().remove(1);
                                        }
                                        if(currPTopping != null && currFlavor.getItemList().size()-1 == 0) {
                                            currPTopping.getItemList().remove(1);
                                        }
                                        if(currTopping != null && currTopping.getItemList().size()-1 == 0) {
                                            currTopping.getItemList().remove(1);
                                        }
                                        for(Slot s : ((SpecialVM)vm).getSpecialInventory()) {
                                            if(s.getName().equals("Shaved Ice")) {
                                                s.getItemList().remove(1);
                                                break;
                                            }
                                        }
                                        currentTransaction = 0;
                                        sMenu.getStatusLbl().setText("Success! Preparing order...");
                                        for(int i = 0; i < 5; i++) {
                                            if(i == 0) {
                                                fullPrepMsg += "Shaving ice...\n";
                                            }
                                            if(i == 1) {
                                                if(currFlavor != null) {
                                                    fullPrepMsg += ((Ingredient)currFlavor.getItemList().get(0)).getPreparationMsg() + "\n";
                                                }
                                            }
                                            if(i == 2) {
                                                if(currColor != null) {
                                                    fullPrepMsg += ((Ingredient)currColor.getItemList().get(0)).getPreparationMsg() + "\n";
                                                }
                                            }
                                            if(i == 3) {
                                                if(currPTopping != null) {
                                                    fullPrepMsg += ((Ingredient)currPTopping.getItemList().get(0)).getPreparationMsg() + "\n";
                                                }
                                            }
                                            if(i == 4) {
                                                if(currTopping != null) {
                                                    fullPrepMsg += ((Ingredient)currTopping.getItemList().get(0)).getPreparationMsg() + "\n";
                                                }
                                                fullPrepMsg += "Mixing...\n";
                                            }
                                                
                                            
                                            sMenu.getPrepMsgTA().setText(fullPrepMsg);
                                        }
                                        fullPrepMsg += "Full order completed!\n Total calories: " + totalCalories + "\nEnjoy!";
                                        sMenu.getPrepMsgTA().setText(fullPrepMsg);
                                        
                                     } else {
                                        sMenu.getTransLbl().setText("Not enough funds!");
                                    }
                                } else {
                                    sMenu.getTransLbl().setText("Select ingredients first!");
                                }
                            }
                        });

                        sMenu.setCancelBtn(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(confirmedSelection) {
                                    sMenu.getSpecMsgLbl().setText("Cancelled selection");
                                    confirmedSelection = false;

                                    sMenu.getColorBox().removeAll();
                                    sMenu.getFlavorBox().removeAll();
                                    sMenu.getPToppingBox().removeAll();
                                    sMenu.getToppingBox().removeAll();

                                    sMenu.setColorBoxList(((SpecialVM)vm).getSpecialInventory());
                                    sMenu.setFlavorBoxList(((SpecialVM)vm).getSpecialInventory());
                                    sMenu.setPToppingBoxList(((SpecialVM)vm).getSpecialInventory());
                                    sMenu.setToppingList(((SpecialVM)vm).getSpecialInventory());

                                    sMenu.getColorStock().setText("");
                                    sMenu.getFlavorStock().setText("");
                                    sMenu.getToppingStock().setText("");
                                    sMenu.getPToppingStock().setText("");

                                    currColor = null;
                                    currFlavor = null;
                                    currPTopping = null;
                                    currTopping = null;

                                    totalPrice = 0;
                                    totalCalories = 0;

                                    sMenu.getPrepMsgTA().setText("");

                                    if(currentTransaction > 0) {
                                        sMenu.getTransLbl().setText("Returned " + currentTransaction + " PHP");
                                        currentTransaction = 0;
                                    }
                                }
                            }
                        });

                    }
                });

                fMenu.setVisible(true);
            }
        });
    }
}
