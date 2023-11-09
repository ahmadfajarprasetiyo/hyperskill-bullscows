package bullscows;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDigit = scanner.nextInt();

        if(numberOfDigit > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", numberOfDigit);
            return;
        }


        String seed = "";
        StringBuilder secretCode = new StringBuilder();



        do {
            if(seed.isEmpty()) {
                seed = String.valueOf(System.nanoTime());
                for(int i = 0; i < secretCode.length(); i++) {
                    seed = seed.replace(String.valueOf(secretCode.charAt(i)),"");
                }
            } else {
                secretCode.append(seed.charAt(0));
                seed = seed.replace(String.valueOf(secretCode.charAt(secretCode.length()-1)),"");
            }
        } while(secretCode.length() != numberOfDigit);

        System.out.printf("The random secret number is %s.\n", secretCode);
    }

    private static void grader() {
        final String secretCode = "9305";

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();
        int bulls = 0;
        int cows = 0;

        for(int i = 0; i < secretCode.length(); i++) {
            int indexAnswer = answer.indexOf(secretCode.charAt(i));
            if(i == indexAnswer) {
                bulls++;
            } else if(indexAnswer != -1) {
                cows++;
            }
        }

        if(bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).", bulls, cows);
        } else if(bulls > 0) {
            System.out.printf("Grade: %d bull(s).", bulls);
        } else if(cows > 0) {
            System.out.printf("Grade: %d cow(s).", cows);
        } else {
            System.out.print("Grade: None.");
        }

        System.out.printf(" The secret code is %s.\n", secretCode);
    }
}
