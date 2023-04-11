public class TestOrders {
    public static void main(String[] args){

        // Menu items
        Item item1 = new Item("drip coffee", 1.50);
        Item item2 = new Item("cappuccino", 2.75);
        Item item3 = new Item("iced coffee", 1.99);
        Item item4 = new Item("mocha", 3.50);

        // 2 guest orders
        Order order1 = new Order();
        Order order2 = new Order();

        // 3 named orders
        Order order3 = new Order("Grant");
        Order order4 = new Order("Tim");
        Order order5 = new Order("Diana");

        // Add 2 items to each order
        order1.addItem(item4);
        order1.addItem(item2);
        order1.setReady(false);
        order1.display();
        System.out.println(order1.getStatusMessage());
        System.out.println("=============================================");

        order2.addItem(item3);
        order2.addItem(item2);
        order2.setReady(false);
        order2.display();
        System.out.println(order2.getStatusMessage());
        System.out.println("=============================================");

        order3.addItem(item1);
        order3.addItem(item4);
        order3.setReady(true);
        order3.display();
        System.out.println(order3.getStatusMessage());
        System.out.println("=============================================");

        order4.addItem(item2);
        order4.addItem(item2);
        order4.setReady(true);
        order4.display();
        System.out.println(order4.getStatusMessage());
        System.out.println("=============================================");

        order5.addItem(item4);
        order5.addItem(item1);
        order5.setReady(false);
        order5.display();
        System.out.println(order5.getStatusMessage());
        System.out.println("=============================================");
    }
}