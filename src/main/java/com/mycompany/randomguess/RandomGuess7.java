/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomguess;

import java.util.Random;
import javax.swing.JOptionPane;



public class RandomGuess7 {
    public static void main(String[] args) {

        // Get player name
        String playerName = JOptionPane.showInputDialog(null, "Enter your name");
        Player player = new Player(playerName);

        // String manipulations
        String upperName = playerName.toUpperCase();
        String lowerName = playerName.toLowerCase();
        int nameLength = playerName.length();

        // Greeting message
        JOptionPane.showMessageDialog(null, 
            "Hello, " + upperName + "! Let's play a game.\n" +
            "Your name \"" + lowerName + "\" is " + nameLength + " characters long."
        );

        // Generate random number (1–100 to match screenshot example)
        Random num = new Random();
        int answer = num.nextInt(100) + 1;
        System.out.println("The ANS is : " + answer); // Debug

        // Game loop
        while (true) {
            String guess = JOptionPane.showInputDialog(null, 
                player.getName() + ", guess the number between 1 to 100 (0 to quit)");

            try {
                int num1 = Integer.parseInt(guess);
               

                if (num1 == 0) {
                    JOptionPane.showMessageDialog(null, 
                        player.getName() + " gave up! The answer was " + answer);
                    break;
                }

                if (num1 < answer) {
                    JOptionPane.showMessageDialog(null, "Wrong! Your guess was too small.");
                } else if (num1 > answer) {
                    JOptionPane.showMessageDialog(null, "Wrong! Your guess was too big.");
                } else {
                    // Build result message using StringBuilder
                    StringBuilder message = new StringBuilder();
                    message.append("Well done, ").append(player.getName().toUpperCase()).append("!\n");
                    message.append("You guessed the number ").append(answer);
                    message.append(" in ").append(player.getAttempts()).append(" attempt(s).\n");
                    message.append("You got there eventually!");

                    JOptionPane.showMessageDialog(null, message.toString());
                    break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Must be a number!");
            }
        }
    }
}
