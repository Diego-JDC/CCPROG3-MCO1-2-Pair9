/**
 * Child class of Item class
 */

public class Ingredient extends Item {
    private String preparationMsg;
    private String type;

    /**
     * Constructor
     * @param name name of ingredient
     * @param calories number of calories
     * @param price price of ingredient
     * @param pMsg preparation message
     * @param type type of ingredient
     */

    public Ingredient(String name, int calories, int price, String pMsg, String type) {
        super(name, calories, price);
        this.preparationMsg = pMsg;
        this.type = type;
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
