import java.util.ArrayList;


public class PuzzleTest {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("10 Random Numbers " + randomRolls);

        char randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        String randomPassword = generator.generatePassword();
        System.out.println("Random Password: " + randomPassword);
    }
}