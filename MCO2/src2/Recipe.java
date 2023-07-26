package MCO2.src2;

import java.util.ArrayList;

public class Recipe {
    private final String name = "Ice Scramble Recipe";
    private ArrayList<Ingredient> ingredientList; // ingredients consist of two types: Base & Topping
    private double totalCalories;

    public Recipe() {
        this.ingredientList = new ArrayList<Ingredient>();
        this.totalCalories = 0;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredientList() {
        return this.ingredientList;
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    public void setTotalCalories(double amount) {
        this.totalCalories = amount;
    }
}
