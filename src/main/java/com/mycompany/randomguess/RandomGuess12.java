package com.mycompany.randomguess;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class RandomGuess12 {
    public static void main(String[] args) {
        String playerName = JOptionPane.showInputDialog(
            null, "Hello! Please enter your name:", 
            "Welcome", JOptionPane.QUESTION_MESSAGE
        );

        if (playerName == null || playerName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No name entered. Exiting game.", 
                "Goodbye", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int totalRounds = 3;
        int maxGuesses = 20;
        int[][] guesses = new int[totalRounds][maxGuesses];
        int[] guessCounts = new int[totalRounds];
        int totalAttempts = 0;

        JOptionPane.showMessageDialog(null, 
            "Hello, " + playerName.toUpperCase() + "!\nLet's play " + totalRounds + " rounds of the guessing game.",
            "Game Start", JOptionPane.INFORMATION_MESSAGE
        );

        for (int round = 0; round < totalRounds; round++) {
            int start = JOptionPane.showConfirmDialog(null, 
                "Ready to start Round " + (round + 1) + "?", 
                "Round Start", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (start != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Game exited. Goodbye " + playerName + "!", 
                    "Exit", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Random rand = new Random();
            int answer = rand.nextInt(100) + 1;
            int attempts = 0;

            while (true) {
                String input = JOptionPane.showInputDialog(
                    null, "Round " + (round + 1) + " - Guess a number (1–100):",
                    "Guess Input", JOptionPane.QUESTION_MESSAGE
                );

                if (input == null) {
                    JOptionPane.showMessageDialog(null, 
                        "You quit! The answer was " + answer, 
                        "Round Over", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int guess = Integer.parseInt(input.trim());

                    if (guess < 1 || guess > 100) {
                        JOptionPane.showMessageDialog(null, 
                            "Please enter a number between 1 and 100.", 
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    guesses[round][attempts] = guess;
                    attempts++;
                    totalAttempts++;
                    guessCounts[round] = attempts;

                    if (guess == answer) {
                        JOptionPane.showMessageDialog(null, 
                            "Correct! You guessed it in " + attempts + " attempt(s).",
                            "Round Complete", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else if (guess < answer) {
                        JOptionPane.showMessageDialog(null, "Too small!", 
                            "Hint", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Too big!", 
                            "Hint", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Please enter a valid number.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Summary
        StringBuilder summary = new StringBuilder("Game Summary for " + playerName.toUpperCase() + ":\n");
        for (int round = 0; round < totalRounds; round++) {
            summary.append("Round ").append(round + 1).append(" (")
                   .append(guessCounts[round]).append(" attempt(s)): ")
                   .append(Arrays.toString(Arrays.copyOfRange(guesses[round], 0, guessCounts[round])))
                   .append("\n");
        }
        summary.append("\nTotal Attempts: ").append(totalAttempts);

        JOptionPane.showMessageDialog(null, summary.toString(), 
            "Game Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
