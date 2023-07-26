package MCO2.src2;

import java.util.ArrayList;

public class SpecialVM extends VendingMachine {
    private Recipe iceScramble;

    //order of operations for ingredient preparation
    private String[] ingredientOrder = {"Shaved Ice","Powdered Milk", 
                                         "Extract", "Food Color", "Topping"};

    public SpecialVM(String name) {
        super(name);
    }

    public Recipe getRecipe() {
        return this.iceScramble;
    }

    public void prepareRecipe() { // NOTE: only assumes that checkRecipe() is TRUE
        for(int i = 0; i < ingredientOrder.length; i++) {//for each ingredient order
            for(Ingredient ing : iceScramble.getIngredientList()) { //for each slot in recipe's ingredient list
                if(ing.getType().equals(ingredientOrder[i])) {
                    //display prep msg
                    //remove ingredient from 
                }
                
            }
        }
    }

    //TEMPORARY
    //checks if the recipe contains all ingredients necessary to complete an order
    public boolean checkRecipe() {
        boolean ret = false;
        int complete = 0; // counter for successful ingredients that made it in
        if(!iceScramble.getIngredientList().isEmpty()) { // false if ingredient list is empty
            for(int i = 0; i < ingredientOrder.length; i++) { // for each ingredient order
                for(Ingredient ing : iceScramble.getIngredientList()) { // for each ingredient present in the ingredient list
                    if(ing.getType().equals(ingredientOrder[i])) { // is the types match
                        i++; // go to the next ingredient in ingredient order.
                        complete++;
                    }
                }
            }
            if(complete < ingredientOrder.length) {
                ret = false;
            } else if(complete == ingredientOrder.length) {
                ret = true;
            }
        }
        return ret;
    }
}
