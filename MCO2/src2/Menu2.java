import java.util.Scanner;

public class Menu2 {
    private VendingMachine currentVM;

    public Menu(VendingMachine vm) {
        this.currentVM = vm;
    }

    public Menu() {}

    public void testVendingFeatures(){
        Scanner scan = new Scanner(System.in);
        int choice;
        int transaction = 0; // stores the cash in machine during transaction.
        int cash = 0;
        int change = 0;
        String confirm = "n"; // confirms if user wants to proceed with transaction after inputting cash.
        char charConfirm = 'n';
        boolean validCash; // checks if cash input is valid
        boolean inputCheck = true;

        
    }
}
