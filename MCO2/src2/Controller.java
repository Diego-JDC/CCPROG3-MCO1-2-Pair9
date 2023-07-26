import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Controller {
    private ViewMenu view;
    private Factory factory;
    private VendingMachine vm;

    public Controller(ViewMenu view, Factory factory){
        this.view = view;
        this.factory = factory;

        this.view.setCreateBtn(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                CreateMenu cMenu = new CreateMenu();
                cMenu.setVisible(true);
                view.setEnabled(false);

                cMenu.setBack(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        view.setEnabled(true);
                        cMenu.dispose();
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
            }
        });
    }
}
