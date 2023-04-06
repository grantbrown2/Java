public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double coffee = 2.29;
        double latte = 3.65;
        double cappuccino = 2.79;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Grant";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println("===================================");
        // ** Your customer interaction print statements will go here ** //
        System.out.println(isReadyOrder1 ? customer1 + readyMessage : customer1 + pendingMessage);
        System.out.println("===================================");
        System.out.println(isReadyOrder2 ? customer2 + readyMessage + " " + displayTotalMessage + cappuccino : customer2 + pendingMessage);
        System.out.println("===================================");
        System.out.println(isReadyOrder3 ? customer3 + readyMessage + " " + displayTotalMessage + (latte * 2) : customer3 + pendingMessage);
        System.out.println("===================================");
        System.out.println(customer4 + " " + displayTotalMessage + (latte - coffee));
    }
}