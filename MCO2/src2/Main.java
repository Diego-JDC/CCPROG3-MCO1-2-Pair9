

public class Main {
    //THIS IS WHERE WE RUN THE MCO2
    public static void main(String[] args) {
        Factory factory = new Factory();
        ViewMenu view = new ViewMenu();
        view.setVisible(true);
        Controller cont = new Controller(view, factory);
    }
}
