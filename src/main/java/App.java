import view.UI;
import Controller.Invoice_Controller;

/*
*  INFO
*   to run the app please run the app form here
* */


public class App {
    public static void main(String[] args) throws InterruptedException {
        UI v = new UI();
        Invoice_Controller c = new Invoice_Controller(v);
        v.runUI();
    }
}