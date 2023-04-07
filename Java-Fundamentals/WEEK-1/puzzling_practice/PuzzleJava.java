import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        Random randMachine = new Random();
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            rolls.add(randMachine.nextInt(20) + 1);
        }
        return rolls;
    }

    public char getRandomLetter() {
        Random randMachine = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int randomIdx = randMachine.nextInt(alphabet.length);
        return alphabet[randomIdx];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }

}