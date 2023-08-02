/**
 * Main class that runs the program
 */

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        SpecialVM vm = new SpecialVM("Test machine");
        
        vm.setIncome(100);

        //ITEMS THAT ARE EXCLUSIVELY PART OF REGULAR VM
        Item sandwich = new Item("Sandwich", 34, 30);
        Item water = new Item("Water bottle", 0, 12);
        
        //ITEMS THAT CAN BE SOLD INDIVIDUALLY AND BE PART OF SPECIAL VM
        
        Ingredient stikO = new Ingredient("Stik-O", 7, 2, "Adding Stik-O...", "Topping");
        Ingredient iceCream = new Ingredient("Ice Cream", 350, 40, "Scooping and placing ice cream...", "Topping");

        //ITEMS THAT ARE EXCLUSIVELY FOR SPECIALVM
        Ingredient miloPowder = new Ingredient("Milo Powder", 11, 5, "Sprinkling Milo Powder...", "Powdered Topping");
        Ingredient milkPowder = new Ingredient("Milk Powder", 20, 11, "Adding Milk Powder...", "Powdered Topping");
        Ingredient vanillaExtract = new Ingredient("Vanilla Extract", 7, 9, "Adding Vanilla Extract...", "Flavor Extract");
        Ingredient bananaExtract = new Ingredient("Banana Extract", 5, 6, "Adding Banana Extract...", "Flavor Extract");
        Ingredient pinkFoodColor = new Ingredient("Pink", 0, 1, "Coloring ice scramble pink...", "Food Color");
        Ingredient yellowFoodColor = new Ingredient("Yellow", 0, 1, "Coloring ice scramble yellow...", "Food Color");

        vm.getSpecialInventory().add(new Slot(miloPowder.getName(), miloPowder.getCalories(), miloPowder.getPrice()));
        vm.getSpecialInventory().add(new Slot(milkPowder.getName(), milkPowder.getCalories(), milkPowder.getPrice()));

        vm.getSpecialInventory().add(new Slot(vanillaExtract.getName(), vanillaExtract.getCalories(), vanillaExtract.getPrice()));
        vm.getSpecialInventory().add(new Slot(bananaExtract.getName(), bananaExtract.getCalories(), bananaExtract.getPrice()));

        vm.getSpecialInventory().add(new Slot(stikO.getName(), stikO.getCalories(), stikO.getPrice()));
        vm.getSpecialInventory().add(new Slot(iceCream.getName(), iceCream.getCalories(), iceCream.getPrice()));

        vm.getSpecialInventory().add(new Slot(yellowFoodColor.getName(), yellowFoodColor.getCalories(), yellowFoodColor.getPrice()));
        vm.getSpecialInventory().add(new Slot(pinkFoodColor.getName(), pinkFoodColor.getCalories(), pinkFoodColor.getPrice()));

        vm.addSlot(new Slot(sandwich.getName(), sandwich.getCalories(), sandwich.getPrice()));
        vm.addSlot(new Slot(water.getName(), water.getCalories(), water.getPrice()));

        vm.stockItem(sandwich, 3);
        vm.stockItem(water, 3);
        
        vm.stockItem(stikO, 3);
        vm.stockItem(iceCream, 3);

        vm.stockItem(miloPowder, 3);
        vm.stockItem(milkPowder, 3);

        vm.stockItem(vanillaExtract, 3);
        vm.stockItem(bananaExtract, 3);

        vm.stockItem(pinkFoodColor, 3);
        vm.stockItem(yellowFoodColor, 3);
        factory.addToVendingMachineList(vm);
        ViewMenu view = new ViewMenu();
        view.setVisible(true);
        Controller cont = new Controller(view, factory);
    }
}
