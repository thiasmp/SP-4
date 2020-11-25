import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu
{

    ArrayList<Pizza> menuCard = new ArrayList<Pizza>();
    ArrayList<Pizza> orderlist = new ArrayList<Pizza>();
    MarioJDBC marioJDBC = new MarioJDBC();

    public Order()  {
        populateMenuCard();
    }

    public Menu() {
        System.out.println("populating menucard...");
        populateMenuCard();
        System.out.println("Menucard size: " + menuCard.size());
    }

    public ArrayList<Pizza> getMenu() {
        return menuCard;
    }

    public void showMenu() {
        for (Pizza p : menuCard) {
            System.out.println(p);
        }
    }
    public void showOrder() {

    }

    private void populateMenuCard() {
        menuCard = marioJDBC.getMenuFromDB();
    }
    private void populateOrder()    {
        orderlist = marioJDBC.getOrderFromDB();
    }

}
