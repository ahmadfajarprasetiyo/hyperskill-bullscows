package bullscows;

import java.util.*;

class BullsAndCows {
    String secretCode;

    void generateSecretCode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");

        int numberOfDigit = scanner.nextInt();

        if(numberOfDigit > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", numberOfDigit);
            return;
        }

        List<Character> numbers = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        final Random r = new Random();
        StringBuilder secretCode = new StringBuilder();
        Collections.shuffle(numbers, r);

        for (int i = 0; i < numberOfDigit; i++) {
            secretCode.append(numbers.get(i));
        }

        this.secretCode = secretCode.toString();

        System.out.println("Okay, let's start a game!");
    }

    void grader() {
        if(this.secretCode == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int j = 1;
        int bulls = 0;
        int cows;

        while (bulls != this.secretCode.length()) {
            bulls = 0;
            cows = 0;
            String bullsString = "bull";
            String cowsString = "cow";

            System.out.printf("Turn %d:\n", j);
            j++;
            String answer = scanner.nextLine();

            for(int i = 0; i < this.secretCode.length(); i++) {
                int indexAnswer = answer.indexOf(this.secretCode.charAt(i));
                if(this.secretCode.charAt(i) == answer.charAt(i)) {
                    bulls++;
                } else if(indexAnswer != -1) {
                    cows++;
                }
            }

            if(bulls > 1) {
                bullsString = "bulls";
            }

            if(cows > 1) {
                cowsString = "cows";
            }

            if(bulls > 0 && cows > 0) {
                System.out.printf("Grade: %d %s and %d %s.", bulls, bullsString, cows, cowsString);
            } else if(bulls > 0) {
                System.out.printf("Grade: %d %s.", bulls, bullsString);
            } else if(cows > 0) {
                System.out.printf("Grade: %d %s.", cows, cowsString);
            } else {
                System.out.print("Grade: None.");
            }
            System.out.println();
        }


        System.out.println("Congratulations! You guessed the secret code.");
    }
}
