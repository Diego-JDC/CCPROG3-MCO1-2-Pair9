

public class Main {
    //THIS IS WHERE WE RUN THE MCO2
    public static void main(String[] args) {
        Factory factory = new Factory();
        VendingMachine vm = new VendingMachine("Test machine");
        
        vm.setIncome(100);
        Item marshmallows = new Item("Marshmallows", 200.0, 30);
        Item chocolate = new Item("Chocolate", 100.0, 20);
        Item iceCream = new Item("Ice Cream", 350.0, 40);
        Item wafers = new Item("Wafers", 20.0, 10);
        Item cookies = new Item("Cookies", 35.0, 25);
        Item strawberries = new Item("Strawberries", 15.0, 16);
        Item water = new Item("Water bottle", 0, 12);
        Item banana = new Item("Banana", 17.5, 22);
        Item mango = new Item("Mango", 22, 17);
        Item milk = new Item("Milk bottle", 22, 100);
        Item pineapple = new Item("Pineapple", 2, 7);

        factory.addToVendingMachineList(vm);
        vm.addSlot("chocolate");
        vm.addSlot("marshmallows");
        vm.addSlot("ice Cream");
        vm.addSlot("Wafers");
        vm.addSlot("Cookies");
        vm.addSlot("Strawberries");
        vm.addSlot("Water bottle");
        vm.addSlot("BAnANA");
        vm.addSlot("MaNGO");
        vm.addSlot("MiLK BOtTLe");
        vm.addSlot("Pineapple");

        vm.stockItem(marshmallows, 10);
        vm.stockItem(mango, 12);
        vm.stockItem(milk, 4);
        vm.stockItem(chocolate, 10);
        vm.stockItem(iceCream, 10);
        vm.stockItem(wafers, 11);
        vm.stockItem(cookies, 12);
        vm.stockItem(strawberries, 13);
        vm.stockItem(water, 9);
        vm.stockItem(banana, 16);
        vm.stockItem(pineapple, 1);

        ViewMenu view = new ViewMenu();
        view.setVisible(true);
        Controller cont = new Controller(view, factory);
    }
}
