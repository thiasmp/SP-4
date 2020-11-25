import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Order {
    static Scanner input = new Scanner(System.in);
    static char t;
    public int time;
    public Date deliveryTime = new Date (System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(this.time));



    public int getTime() {
        return time;
    }

    static int pizzaNumber = 1;
    static int j = 0;
    static ArrayList<String> orders = new ArrayList<>();
    public static int orderID;
    static String testNewString;
    static private BufferedWriter writer;
    static private BufferedReader reader;
    private static ArrayList tempList = new ArrayList();
    private static File tempFile = new File("orderList.txt");

    public ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private Menu menu = new Menu();


    public void selectPizza()  {

        boolean finished = false;
        while (!finished) {
            String choice = input.nextLine();
            pizzaNumber = Integer.parseInt(choice); // TODO: Handle if input is not a number (validateInputs)
            switchOptions();
        }
    }

    public void addPizza() {

        //Main.mariosSystem.activeOrders.add(String.valueOf(Menu.getMenu().get(i-1)));

        pizzas.add(menu.getMenu().get(pizzaNumber - 1));
        System.out.println("The following pizza has been added to the order:");
        System.out.println(pizzas.get(pizzas.size() -1));
        System.out.println("Do u want more? (Y/N)");
    }

    public void addAnotherPizza()  {
        menu.showMenu();
        System.out.println("What's next?");
    }

    public void pickUp () {

        System.out.println("When should the order be rdy?" + "\n Type: (F/M/S)");
        System.out.println("Fast = 15 min");
        System.out.println("Medium = 30 min");
        System.out.println("Slow = 60 min");
        t = input.nextLine().charAt(0);
        if (t == 'F' || t == 'f') {
            time = 15;
            System.out.println("You choose: " + time + "min");
        } else if (t == 'M' || t == 'm') {
            time = 30;
            System.out.println("You choose: " + time + "min");
        } else if (t == 'S' || t == 's') {
            time = 60;
            System.out.println("You choose: " + time + "min");
        }
        setJ(0);
    }

    public static void setJ(int j) {
        Order.j = j;
    }

    public void switchOptions() {
        addPizza();
        Main.buyMore = input.nextLine().charAt(0);
        if (Main.buyMore == 'Y' || Main.buyMore == 'y') {
            addAnotherPizza();
        } else {
            pickUp();
            System.out.println("You need to pay:");
            getTotalPrice();
            MarioJDBC marioJDBC = new MarioJDBC();
            marioJDBC.saveOrderToDatabase(this);
            orderID++;
            Main.options();
        }
    }

    private int getTotalPrice() {
        int totalPrice = 0;

        for(Pizza p : pizzas)
        {
            totalPrice += p.getPrice();

        }
        System.out.println(totalPrice);
        return totalPrice;

    }

    public void orderIDString() {
        orderID++;
        String orderIDNewString = String.format("%05d", orderID);
        testNewString = orderIDNewString;
    }
}