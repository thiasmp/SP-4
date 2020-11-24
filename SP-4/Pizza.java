public class Pizza {

private int id;
private String name;
private String topping;
private int price;

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
