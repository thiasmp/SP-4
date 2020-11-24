import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static char buyMore;

    static Order order;
    static Menu menu;
    static MariosSystem mariosSystem;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {


        menu = new Menu();
        mariosSystem = new MariosSystem();
        options();

    }

    public static void options() throws SQLException, ClassNotFoundException {
        System.out.println(mariosSystem.step1.get(0));
        System.out.println(mariosSystem.step1.get(1));
        System.out.println(mariosSystem.step1.get(3));
        System.out.println(mariosSystem.step1.get(4));
        boolean finished = false;
        while (!finished){
            String choice = input.nextLine();
            switch (choice){
                case"1":
                    menu.showMenu();
                    //System.out.println(menu);
                    options();
                    break;
                case"2":
                    order = new Order();
                    order.orderIDString();
                    menu.showMenu();
                    //System.out.println(menu);
                    System.out.println(mariosSystem.step1.get(2));
                    order.selectPizza();
                    break;
                case "3":
                   // Statistik.readSortedOrderList();
                    options();
                    break;
                case "4":
                  //  Statistik.readOrderList();
                    Order.removeOrder();
                    options();
            }
        }
    }
}