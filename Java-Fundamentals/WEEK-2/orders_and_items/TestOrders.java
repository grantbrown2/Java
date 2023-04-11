import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item cheesePizza = new Item();
        cheesePizza.name = "Cheese Pizza";
        cheesePizza.price = 13.99;

        Item pepperoniPizza = new Item();
        pepperoniPizza.name = "Pepperoni Pizza";
        pepperoniPizza.price = 15.99;

        Item buffaloChickenPizza = new Item();
        buffaloChickenPizza.name = "Buffalo Chicken Pizza";
        buffaloChickenPizza.price = 17.99;

        Item hawaiianPizza = new Item();
        hawaiianPizza.name = "Hawaiian Pizza";
        hawaiianPizza.price = 16.99;
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Grant";
        order1.ready = true;
        order1.items = new ArrayList<Item>();
        order1.items.add(pepperoniPizza);
        order1.total = addTotal(order1.items);

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.ready = true;
        order2.items = new ArrayList<Item>();
        order2.items.add(cheesePizza);
        order2.total = addTotal(order2.items);

        Order order3 = new Order();
        order3.name = "Noah";
        order3.ready = false;
        order3.items = new ArrayList<Item>();
        order3.items.add(buffaloChickenPizza);
        order3.total = addTotal(order3.items);

        Order order4 = new Order();
        order4.name = "Sam";
        order4.ready = false;
        order4.items = new ArrayList<Item>();
        order4.items.add(hawaiianPizza);
        order4.items.add(cheesePizza);
        order4.items.add(cheesePizza);
        order4.total = addTotal(order4.items);

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("==================================\n");

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        System.out.printf("==================================\n");

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        System.out.printf("==================================\n");

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        System.out.printf("==================================\n");
    }
    public static double addTotal(ArrayList<Item> items) {
            double total = 0.0;
            for (Item item: items) {
                total += item.price;
            }
            return total;
        }
}
