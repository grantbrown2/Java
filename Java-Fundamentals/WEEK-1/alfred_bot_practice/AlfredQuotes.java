import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello %s, how might I be of assistance?", name);
    }
    
    public String dateAnnouncement() {
        Date day = new Date();
        return "Sir, todays date is\n" + day;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int alexis = conversation.indexOf("Alexis");
        int alfred = conversation.indexOf("Alfred");
        if (alexis >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if (alfred >= 0) {
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

