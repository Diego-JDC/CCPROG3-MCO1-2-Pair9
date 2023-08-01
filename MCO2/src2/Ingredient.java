public class Ingredient extends Item {
    private String preparationMsg;

    public Ingredient(String name, double calories, int price, String pMsg) {
        super(name, calories, price);
        this.preparationMsg = pMsg;
    }

    public void setPreparationMsg(String msg) {
        this.preparationMsg = msg;
    }

    public String getPreparationMsg() {
        return this.preparationMsg;
    }
}
