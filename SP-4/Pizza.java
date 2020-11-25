import java.sql.Date;

public class Pizza {

private int id;
private String name;
private String topping;
private int price;

private int orderID;
private int deliveryTime;
private int pizzaID;
private int TotalPrice;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public OrderList(int orderID, Date deliveryTime, int pizzaID, int totalPrice) {
        this.orderID = orderID;
        this.deliveryTime = deliveryTime;
        this.pizzaID = pizzaID;
        TotalPrice = totalPrice;
    }

    public Pizza(int id, String name, String topping, int price) {
        this.id = id;
        this.name = name;
        this.topping = topping;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + topping + "\t" + price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
