import java.util.ArrayList;
import java.util.Scanner;

public class ComboFood {
    private ArrayList<Item> recipe;
    private double calories;
    private String name;

    public ComboFood(String name){
        this.name = name;
        this.recipe = new ArrayList<>(recipe);
        this.calories = 0;
    }

    public void setCalories(double calories){
        this.calories = calories;
    }

    // nAdd is the number of ingredients to add to recipe
    public void setRecipe(int nAdd){
        
    }
}
