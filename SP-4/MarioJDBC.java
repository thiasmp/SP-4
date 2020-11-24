import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MarioJDBC {

    private Connection conn;
    String JdbcUrl = "jdbc:mysql://localhost/MariosPizza?" + "autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "Abesnot1!";

    public MarioJDBC() {
        createConnection();
    }

    public void createConnection() {
        try {
            conn = DriverManager.getConnection(JdbcUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Pizza> getMenuFromDB() {
        // TODO: have a look at preparedStatements!
        ArrayList<Pizza> tmp = new ArrayList<Pizza>();

        try {
            if(!conn.isValid(1))
            {
                System.out.println("No connection found");
                createConnection();
            }

            System.out.println("Am I here?");
            Statement stm;
            stm = conn.createStatement();
            System.out.println("Statement created");
            String sql = "select * from MariosPizza.Pizza";

            ResultSet resultSet;

            resultSet = stm.executeQuery(sql);

            while (resultSet.next()) {
                Pizza pizza = new Pizza(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("Topping"),
                        resultSet.getInt("Price")
                );

                tmp.add(pizza);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tmp;
    }


//
//        Connection

//


    // insertOrder
    public void saveOrderToDatabase(Order o)
    {
        String sql = "INSERT INTO mariospizza.order (OrderID, deliveryTime, pizzaID) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            java.util.Date utilDate = new java.util.Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(o.time));
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            for (Pizza p : o.pizzas)
            {
                ps.setInt(1, o.orderID);
                ps.setDate(2, sqlDate);
                ps.setInt(3,p.getId());

                ps.execute();
                // TODO: Increment static orderID
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
