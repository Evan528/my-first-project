package com.mycompany.randomguess;

import java.util.Random;
import java.util.Arrays;
import javax.swing.JOptionPane;

// Superclass
class BasicGame {
    protected String playerName;
    protected int answer;
    protected int[] guesses;
    protected int attempt;

     // Generate random number (1–100 to match screenshot example)
    public BasicGame(String playerName) {
        this.playerName = playerName;
        this.guesses = new int[100];
        this.attempt = 0;
        Random num = new Random();
        this.answer = num.nextInt(100) + 1;
        System.out.println("The ANS is : " + answer); // Debug
    }

    //Uses a Array to store the attempts
    public void storeGuess(int guess) {
        guesses[attempt] = guess;
        attempt++;
    }

    public boolean isCorrectGuess(int guess) {
        return guess == answer;
    }
}

// Subclass
class AdvancedGame extends BasicGame {
    public AdvancedGame(String playerName) {
        super(playerName);
    }

     // Get player name
    public void play() {
        JOptionPane.showMessageDialog(null,
            "Hello, " + playerName.toUpperCase() + "! Let's play an advanced guessing game."
        );

        while (true) {
            String guessStr = JOptionPane.showInputDialog(
                null, playerName + ", guess the number between 1 and 100 (0 to quit)"
            );

            if (guessStr == null) {
                JOptionPane.showMessageDialog(null,
                    playerName + " quit the game! The answer was " + answer);
                break;
            }

            try {
                int guess = Integer.parseInt(guessStr.trim());
                storeGuess(guess);

                if (guess == 0) {
                    JOptionPane.showMessageDialog(null,
                        playerName + " gave up! The answer was " + answer);
                    break;
                }
   // String manipulations
                if (isCorrectGuess(guess)) {
                    JOptionPane.showMessageDialog(null,
                        "Well done, " + playerName.toUpperCase() + "!\n" +
                        "You guessed the number " + answer + " in " + attempt + " attempt(s).\n" +
                        "Your guesses: " + Arrays.toString(Arrays.copyOfRange(guesses, 0, attempt))
                    );
                    break;
                } else if (guess < answer) {
                    JOptionPane.showMessageDialog(null, "Too small!");
                } else {
                    JOptionPane.showMessageDialog(null, "Too big!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        }
    }
}

// Main file
public class RandomGuess10 {
    public static void main(String[] args) {
        String playerName = JOptionPane.showInputDialog(null, "Enter your name");
        AdvancedGame game = new AdvancedGame(playerName);
        game.play();
    }
}
