import java.util.ArrayList;

public class MariosSystem {
    ArrayList<String> step1 = new ArrayList<>();
    ArrayList<String> activeOrders = new ArrayList<>();

    public MariosSystem() {
        this.step1.add("Press 1 to show Menu");
        this.step1.add("Press 2 to make a new Order");
        this.step1.add("Choose a Pizza");
        this.step1.add("Press 3 to show list of orders");
        this.step1.add("Press 4 to remove orders");
    }
}
