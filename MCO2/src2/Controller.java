import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        
        // Adds actionlistneer to "create" button
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

                mMenu.setBack(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        view.setEnabled(true);
                        mMenu.dispose();
                    }
                });

                mMenu.setPriceBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        ArrayList<Slot> list = vm.getInventory();
                        mMenu.hideAll();
                        mMenu.setItemList(list);
                        mMenu.showPriceMenu();

                        Slot s = mMenu.getSelected();
                        mMenu.setPriceLabel(s.getItemPrice());

                        mMenu.setItemListBtn(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                Slot s = mMenu.getSelected();
                                mMenu.hideMessage();
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
                                mMenu.showMessage();
                            }
                        });
                    }
                });
                
                
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

                mMenu.setCollectBtn(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        mMenu.hideAll();
                        mMenu.showCollect();
                        ArrayList<VendingMachine> currentList = factory.getVendingMachineList();
                        VendingMachine vm = currentList.get(currentList.size()-1);
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

                mMenu.setSummaryBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        mMenu.hideAll();
                        mMenu.showTransactionMenu();
                    }
                });
                mMenu.setVisible(true);
            }
        });

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
                fMenu.setVisible(true);
            }
        });
    }
}
