import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public Controller(ViewMenu view, Factory factory){
        this.view = view;
        this.factory = factory;
        this.vm = factory.getVendingMachineList().get(factory.getVendingMachineList().size() - 1);
        
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

                        if(name.length() > 10){
                            do{
                                cMenu.showErrMsg();
                                cMenu.resetTextField();
                                name = cMenu.getName();
                            }while(name.length() > 10);
                        }

                        else{
                            cMenu.showOptions();
                            
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
                    int pressedBtn = 0; // so that the table gets set up only ONCE
                    public void actionPerformed(ActionEvent e){
                        if(pressedBtn == 0) {
                            mMenu.setTable(vm);
                            pressedBtn++;
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

                                if(vm instanceof SpecialVM){
                                    ingBtn.setVisible(true);
                                    regBtn.setVisible(true);
                                }

                                mMenu.setAddItemBtn(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        mMenu.hideAddMessage();
                                        Slot slot = new Slot(mMenu.getNewItemName());
                                        if(vm instanceof SpecialVM){
                                            if(ingBtn.isSelected()){
                                                Ingredient ing = new Ingredient(mMenu.getNewItemName(), 
                                                mMenu.getNewCalories(), mMenu.getNewPrice(), 
                                                "Adding " + mMenu.getNewItemName() + " to Ice Scramble...");
                                                slot.addItem(ing);
                                                slot.setInitQuantity(1);
                                                ((SpecialVM)vm).getSpecialInventory().add(slot);
                                            }
                                            else if(regBtn.isSelected()){
                                                Item item = new Item(mMenu.getNewItemName(), mMenu.getNewCalories(), mMenu.getNewPrice());
                                                slot.setInitQuantity(1);
                                                slot.addItem(item);
                                                vm.getInventory().add(slot);
                                            }
                                            else if(regBtn.isSelected() && ingBtn.isSelected()){
                                                Ingredient ing = new Ingredient(mMenu.getNewItemName(), 
                                                mMenu.getNewCalories(), mMenu.getNewPrice(), 
                                                "Adding " + mMenu.getNewItemName() + " to Ice Scramble...");
                                                slot.setInitQuantity(1);
                                                slot.addItem(ing);
                                                vm.getInventory().add(slot);
                                                ((SpecialVM)vm).getSpecialInventory().add(slot);
                                            }
                                        }
                                        else{
                                            Item item = new Item(mMenu.getNewItemName(), mMenu.getNewCalories(), mMenu.getNewPrice());
                                            slot.setInitQuantity(1);
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
                                mMenu.setCurrentStock(currList.size());

                                mMenu.setRestockList(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        Slot s = mMenu.getSelectedRestock();
                                        ArrayList<Item> currList = s.getItemList();
                                        mMenu.setCurrentStock(currList.size());
                                    }
                                });

                                mMenu.setRestockBtn(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        Slot s = mMenu.getSelectedRestock();
                                        ArrayList<Item> currList = s.getItemList();
                                        s.setInitQuantity(s.getItemList().size() + mMenu.getInputStock());
                                        s.addItem(s.getItemList().get(0), mMenu.getInputStock());
                                        mMenu.setCurrentStock(currList.size());
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
                ArrayList<VendingMachine> currentList = factory.getVendingMachineList();
                VendingMachine vm = currentList.get(currentList.size()-1);
                fMenu.setVendingMachineName(VMNameHolder + vm.getName());
                if(vm instanceof SpecialVM) {
                    fMenu.setType(VMTypeHolder + "Special");
                } else {
                    fMenu.setType(VMTypeHolder + "Regular");
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
                            if(name.equals(s.getName())){
                                fMenu.updateSelect(s.getName());
                            }
                        }
                    }
                });

                fMenu.setInsertBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if(vm.isValidDenomination(fMenu.getCashField())){
                            int currentTransaction = 0;
                            fMenu.updateTransLabel(fMenu.getCashField());
                        }
                        else{
                            fMenu.errorTransLabel();
                        }
                    }
                });

                fMenu.setVisible(true);
            }
        });
    }
}
