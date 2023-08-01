import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private ViewMenu view;
    private Factory factory;
    private VendingMachine vm;
    String VMNameHolder = "Vending Machine: ";
    String VMTypeHolder = "Type: ";

    public Controller(ViewMenu view, Factory factory){
        this.view = view;
        this.factory = factory;

        this.view.setCreateBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){

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

                /*
                 * String name;
                VendingMachine vm = new VendingMachine(null);
                vm = factory.makeVendingMachine("One"); // creates vending machine
                System.out.println("Success!"); // This is just for testing, delete later
                 */
            }
        });

        this.view.setMaintenanceBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MaintenanceMenu mMenu = new MaintenanceMenu();

                mMenu.setPriceBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        mMenu.showPriceMenu();
                    }
                });

                mMenu.setReplenishBtn(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        mMenu.showReplenish();
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
