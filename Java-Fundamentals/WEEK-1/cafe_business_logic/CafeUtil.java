import java.util.ArrayList;
public class CafeUtil {


    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems) {
        double sum = 0;
        for (double price : lineItems) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine(); //gets user inputted value from CMD
        System.out.println("Hello, " + userName);
        int peopleAhead = customers.size();
        String message = "There are " + peopleAhead + " people ahead of you";
        System.out.println(message);
        customers.add(userName);
        System.out.println(customers);
    }
}