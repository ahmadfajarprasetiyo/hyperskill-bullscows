package bullscows;

public class Main {
    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.generateSecretCode();
        bullsAndCows.grader();
    }

}
