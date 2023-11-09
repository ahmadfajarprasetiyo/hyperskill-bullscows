package bullscows;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
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
