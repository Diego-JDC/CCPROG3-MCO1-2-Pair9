

public class Ingredient extends Item {
    private String preparationMsg;
    private String type;

    public Ingredient(String name, double calories, int price, String type, String pMsg) {
        super(name, calories, price);
        this.type = type;
        this.preparationMsg = pMsg;
    }

    public void setPreparationMsg(String msg) {
        this.preparationMsg = msg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPreparationMsg() {
        return this.preparationMsg;
    }

    public String getType() {
        return this.type;
    }
}
