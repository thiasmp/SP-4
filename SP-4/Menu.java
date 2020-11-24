import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    ArrayList<Pizza> menuCard = new ArrayList<Pizza>();
    MarioJDBC marioJDBC = new MarioJDBC();

    public Menu() {
        System.out.println("populating menucard...");
        populateMenuCard();
        System.out.println("Menucard size: "+menuCard.size());
    }

    public ArrayList<Pizza> getMenu()
    {
        return menuCard;
    }

    public void showMenu()
    {
        for(Pizza p : menuCard)
        {
            System.out.println(p);
        }
    }

    private void populateMenuCard()
    {
        menuCard = marioJDBC.getMenuFromDB();
    }

    List<String> temps = new ArrayList<>();

//    public static ArrayList<Pizza> getMenu() throws ClassNotFoundException, SQLException {
//        String JdbcUrl = "jdbc:mysql://localhost/MariosPizza?" + "autoReconnect=true&useSSL=false";
//        String username = "root";
//        String password = "Cervelo2011";
//
//        Connection conn= DriverManager.getConnection(JdbcUrl, username, password);
//        Statement stm;
//        stm = conn.createStatement();
//        String sql = "Select * From Pizza";
//        ResultSet rst;
//        rst = stm.executeQuery(sql);
//        ArrayList<Pizza> menuCard = new ArrayList<>();
//        while (rst.next()) {
//            Pizza pizza = new Pizza(rst.getInt("id"), rst.getString("name"), rst.getString("Topping"), rst.getInt("Price"));
//            menuCard.add(pizza);
//        }
//        return menuCard;
//    }



//
//    public Menu() throws FileNotFoundException {
//
//
//
//        String token1 = "";
//        Scanner menu = new Scanner(new File("Menu.txt"));
//
//        while (menu.hasNextLine()) {
//            token1 = menu.nextLine();
//            temps.add(token1);
//        }
//        menu.close();
//        String[] tempsArray = temps.toArray(new String[0]);
//        for (String s: tempsArray) {
//            System.out.println(s);
//        }
//    }

    /*@Override
    public String toString() {
        return "Mario's Pizza Menukort:" + "\n" + temps.get(1) +
                "\n" + temps.get(2) +
                "\n" + temps.get(3) +
                "\n" + temps.get(4) +
                "\n" + temps.get(5) +
                "\n" + temps.get(6) +
                "\n" + temps.get(7) +
                "\n" + temps.get(8) +
                "\n" + temps.get(9) +
                "\n" + temps.get(10) +
                "\n" + temps.get(11) +
                "\n" + temps.get(12) +
                "\n" + temps.get(13) +
                "\n" + temps.get(14);*/
}