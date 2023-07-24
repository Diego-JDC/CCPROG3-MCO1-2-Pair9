import java.util.ArrayList;

public class SpecialVM extends VendingMachine{

    private ArrayList<ComboFood> comboFoodList;

    public SpecialVM(String name){
        super(name);
        this.comboFoodList = new ArrayList<>(comboFoodList);
    }

    public double computeCalories(){

    }
}
