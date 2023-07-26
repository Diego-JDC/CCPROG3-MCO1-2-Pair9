import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private ViewMenu view;
    private Factory factory;
    private VendingMachine vm;

    public Controller(ViewMenu view, Factory factory){
        this.view = view;
        this.factory = factory;

        this.view.setCreateBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                vm = factory.makeVendingMachine("One");
                System.out.println("Success!"); // This is just for testing, delete later
            }
        });

        this.view.setMaintenanceBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(vm != null){
                    factory.machineMaintenance(vm);
                }
                else{
                    // display error message
                }
            }
        });
    }
}
