public class Ingredient extends Item {
    private String preparationMsg;
    private String type;

    public Ingredient(String name, int calories, int price, String pMsg) {
        super(name, calories, price);
        this.preparationMsg = pMsg;
    }

    public void setPreparationMsg(String msg) {
        this.preparationMsg = msg;
    }

    public String getPreparationMsg() {
        return this.preparationMsg;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
