

public class Main {
    //THIS IS WHERE WE RUN THE MCO2
    public static void main(String[] args) {
        Factory factory = new Factory();
        VendingMachine vm = new VendingMachine("Test machine");
        
        vm.setIncome(100);
        Item marshmallows = new Item("Marshmallows", 200, 30);
        Item chocolate = new Item("Chocolate", 100, 20);
        Item iceCream = new Item("Ice Cream", 350, 40);
        Item wafers = new Item("Wafers", 20, 10);
        Item cookies = new Item("Cookies", 35, 25);
        Item strawberries = new Item("Strawberries", 15, 16);
        Item water = new Item("Water bottle", 0, 12);
        Item banana = new Item("Banana", 17, 22);
        Item mango = new Item("Mango", 22, 17);
        Item milk = new Item("Milk bottle", 22, 100);
        Item pineapple = new Item("Pineapple", 2, 7);

        factory.addToVendingMachineList(vm);
        vm.addSlot(new Slot("chocolate", chocolate.getCalories(), chocolate.getPrice()));
        vm.addSlot(new Slot("marshmallows", marshmallows.getCalories(), marshmallows.getPrice()));
        vm.addSlot(new Slot("ice Cream", iceCream.getCalories(), iceCream.getPrice()));
        vm.addSlot(new Slot("Wafers", wafers.getCalories(), wafers.getPrice()));
        vm.addSlot(new Slot("Cookies", cookies.getCalories(), cookies.getPrice()));
        vm.addSlot(new Slot("Strawberries", strawberries.getCalories(), strawberries.getPrice()));
        vm.addSlot(new Slot("Water bottle", water.getCalories(), water.getPrice()));
        vm.addSlot(new Slot("BAnANA", banana.getCalories(), banana.getPrice()));
        vm.addSlot(new Slot("MaNGO", mango.getCalories(), mango.getPrice()));
        vm.addSlot(new Slot("MiLK BOtTLe", milk.getCalories(), milk.getPrice()));
        vm.addSlot(new Slot("Pineapple", pineapple.getCalories(), pineapple.getPrice()));

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
