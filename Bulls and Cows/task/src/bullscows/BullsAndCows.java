package bullscows;

import java.util.*;

class BullsAndCows {
    String secretCode;

    void generateSecretCode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");

        int numberOfDigit = scanner.nextInt();

        System.out.println("Input the number of possible symbols in the code:");

        int lengthPossible = scanner.nextInt();

        if(numberOfDigit > lengthPossible || lengthPossible > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", numberOfDigit);
            return;
        }

        List<Character> numbers = new ArrayList<>();

        for(int i = 0; i < Math.min(lengthPossible,10); i++) {
            char entity = (char) ('0' + i);
            numbers.add(entity);
        }

        for(int i = 0; i < lengthPossible-10; i++) {
            char entity = (char) ('a' + i);
            numbers.add(entity);
        }

        System.out.print("The secret is prepared: ");
        for(int i = 0; i < numberOfDigit; i++) {
            System.out.print("*");
        }

        if(lengthPossible <= 10) {
            System.out.printf(" (0-%c).\n", numbers.get(numbers.size()-1));
        } else {
            System.out.printf(" (0-9, a-%c).\n", numbers.get(numbers.size()-1));
        }


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
