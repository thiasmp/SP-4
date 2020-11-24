import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Statistik {

    public static void addToFile() {

        try {
            FileWriter myWriter = new FileWriter("statistik.txt",true);
            for (int i = 0; i < Main.mariosSystem.activeOrders.size(); i++) {
                myWriter.write(Main.mariosSystem.activeOrders.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Succsessfully wrote to file.");
            Main.mariosSystem.activeOrders.clear();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

   /* public static void addToOrder() {

        //Date dNow = new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(Order.time));

        try {
            FileWriter myWriter = new FileWriter("orderList.txt",true);
            for (int i = 0; i < Order.orders.size(); i++) {
                //myWriter.write(new Timestamp(new java.util.Date().getTime()).toString().split("\\.")[0]);
                myWriter.write(String.valueOf(dNow));
                myWriter.write("\t");
                myWriter.write(Order.testNewString);
                myWriter.write("\t");
                myWriter.write(Order.orders.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Succsessfully wrote to file.");
            sortOrder();
            Order.orders.clear();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readSortedOrderList() {

        try {
            File myObj = new File("sortedOrderList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void sortOrder() {

        BufferedReader reader = null;
        BufferedWriter writer = null;

        ArrayList<String> orderSort = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("orderList.txt"));
            String currentLine = reader.readLine();
            while (currentLine !=null) {
                orderSort.add(currentLine);
                currentLine = reader.readLine();
            }
            Collections.sort(orderSort);
            writer = new BufferedWriter(new FileWriter("sortedOrderList.txt"));
            for (String line: orderSort) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader !=null) {
                    reader.close();
                }
                if (writer !=null) {
                    writer.close();
                }
                orderSort.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void readOrderList() {
        try {
            File myObj = new File("orderList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//    public static void readDatabase() throws SQLException{
//        Connection connection = null;
//        ResultSet resultSet = null;
//        Statement statement = null;
//
//        String JdbcUrl = "jdbc:mysql://localhost/MariosPizza?" + "autoReconnect=true&useSSL=false";
//        String username = "root";
//        String password = "Cervelo2011";
//
//        try {
//            connection = DriverManager.getConnection(JdbcUrl, username, password);
//            String sql = "select * from MariosPizza.Pizza";
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//            while(resultSet.next()) {
//                int sqlID = resultSet.getInt("ID");
//                String sqlName = resultSet.getString("Name");
//                String sqlTopping = resultSet.getString("Topping");
//                int sqlPrice = resultSet.getInt("Price");
//
//                //int sqling = resultSet.getInt("count(*)");
//                //int sqling = resultSet.getInt("count(*)");
//
//                System.out.println(sqlID + "\t" +  sqlName + "\t" + sqlTopping + "\t" + sqlPrice);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
*/
}

