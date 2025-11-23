package dam.m6.uf2;
import dam.m6.uf2.Controller;
import dam.m6.uf2.MainView;


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainView view = new MainView(controller);
        view.start();
    }
}