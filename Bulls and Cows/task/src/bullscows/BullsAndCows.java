package bullscows;

import java.util.Scanner;

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
