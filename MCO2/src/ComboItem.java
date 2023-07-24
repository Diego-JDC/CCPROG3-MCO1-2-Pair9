public class ComboItem extends Item{
    String pMsg;
    String type;

    public ComboItem(String name, double calories, int price, int initQuantity, 
    String pMsg, String type) {
        super(name, calories, price, initQuantity);
        this.pMsg = "";
        this.type = "";
    }

    public ComboItem(String name, double calories, int price, String pMsg, String type) {
        super(name, calories, price);
        this.pMsg = "";
        this.type = "";
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPreparationMsg(String msg){
        this.pMsg = msg;
    }

    public String getPreparationMsg(){
        return this.pMsg;
    }

    public String getType(){
        return this.type;
    }
}
