package com.mycompany.randomguess;

import java.util.Random;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class RandomGuess11 {
    public static void main(String[] args) {
        String playerName = JOptionPane.showInputDialog(null, "Enter your name");
        int totalRounds = 3; // number of rounds
        int maxGuessesPerRound = 10;

        // guesses[round][guessNumber]
        int[][] guesses = new int[totalRounds][maxGuessesPerRound];
        int[] guessCounts = new int[totalRounds]; // track how many guesses each round

        for (int round = 0; round < totalRounds; round++) {
            Random rand = new Random();
            int answer = rand.nextInt(100) + 1;
            int attempt = 0;
             System.out.println("The ANS is : " + answer); // Debug

            JOptionPane.showMessageDialog(null,
                "Round " + (round + 1) + " of " + totalRounds + "\n" +
                "Guess the number between 1 and 100!"
            );

            while (true) {
                String input = JOptionPane.showInputDialog(
                    null, "Round " + (round + 1) + ": Guess #" + (attempt + 1) +
                    " (0 to quit)"
                );

                if (input == null) {
                    JOptionPane.showMessageDialog(null,
                        playerName + " quit the game. The answer was " + answer);
                    return;
                }

                try {
                    int guess = Integer.parseInt(input.trim());
                    guesses[round][attempt] = guess;
                    attempt++;
                    guessCounts[round] = attempt;

                    if (guess == 0) {
                        JOptionPane.showMessageDialog(null,
                            playerName + " gave up! The answer was " + answer);
                        return;
                    }

                    if (guess == answer) {
                        JOptionPane.showMessageDialog(null,
                            "Correct! The answer was " + answer + "\n" +
                            "You took " + attempt + " guesses this round."
                        );
                        break; // next round
                    } else if (guess < answer) {
                        JOptionPane.showMessageDialog(null, "Too small!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too big!");
                    }

                    if (attempt >= maxGuessesPerRound) {
                        JOptionPane.showMessageDialog(null,
                            "Max guesses reached! The answer was " + answer);
                        break;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a number!");
                }
            }
        }

        // After all rounds — show guesses per round
        StringBuilder results = new StringBuilder("Game Over!\n\n");
        for (int round = 0; round < totalRounds; round++) {
            results.append("Round ").append(round + 1).append(": ")
                   .append(Arrays.toString(Arrays.copyOfRange(guesses[round], 0, guessCounts[round])))
                   .append("\n");
        }
        JOptionPane.showMessageDialog(null, results.toString());
    }
}
