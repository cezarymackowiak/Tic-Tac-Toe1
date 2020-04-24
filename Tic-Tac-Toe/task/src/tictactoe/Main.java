package tictactoe;

import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static char winningChar;

    public static void main(String[] args) {
        int xCounter = 0;
        int oCounter = 0;


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'O')
                oCounter++;
            if (input.charAt(i) == 'X')
                xCounter++;
        }

        System.out.println(check(input, oCounter, xCounter));


    }

    public static String check(String input, int oCounter, int xCounter) {
        String regex = "_";
        int numberOfWins = 0;
        if (abs(oCounter - xCounter) > 1)
            return "Impossible";
        else {
            if (input.charAt(0) == input.charAt(1) && input.charAt(0) == input.charAt(2) && input.charAt(0) != '_') {
                winningChar = input.charAt(0);
                numberOfWins++;
            }

            if (input.charAt(3) == input.charAt(4) && input.charAt(3) == input.charAt(5) && input.charAt(3) != '_') {
                numberOfWins++;
                winningChar = input.charAt(3);
            }

            if (input.charAt(6) == input.charAt(7) && input.charAt(6) == input.charAt(8) && input.charAt(6) != '_') {
                numberOfWins++;
                winningChar = input.charAt(6);
            }
            if (input.charAt(0) == input.charAt(3) && input.charAt(0) == input.charAt(6) && input.charAt(0) != '_') {
                numberOfWins++;
                winningChar = input.charAt(3);
            }
            if (input.charAt(1) == input.charAt(4) && input.charAt(1) == input.charAt(7) && input.charAt(1) != '_') {
                numberOfWins++;
                winningChar = input.charAt(1);
            }
            if (input.charAt(2) == input.charAt(5) && input.charAt(2) == input.charAt(8) && input.charAt(2) != '_') {
                numberOfWins++;
                winningChar = input.charAt(2);
            }
            if (input.charAt(0) == input.charAt(4) && input.charAt(0) == input.charAt(8) && input.charAt(0) != '_') {
                numberOfWins++;
                winningChar = input.charAt(0);
            }
            if (input.charAt(6) == input.charAt(4) && input.charAt(2) == input.charAt(6) && input.charAt(2) != '_') {
                numberOfWins++;
                winningChar = input.charAt(2);
            }
            if (numberOfWins > 1)
                return "Impossible";
            if (numberOfWins == 0 && !input.contains(regex)) {
                return "Draw";
            }
            if (numberOfWins == 0 && input.contains(regex)) {
                return "Game not finished";
            }
            if (numberOfWins == 1) {
                return winningChar + " wins";


            }
        }

        return null;
    }
}