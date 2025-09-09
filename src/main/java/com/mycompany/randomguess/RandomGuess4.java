/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomguess;

import java.util.Random;
import javax.swing.JOptionPane;

public class RandomGuess4 {
    public static void main(String[] args) {

        // Generates the number and displays ANS  
        Random num = new Random();
        int answer = num.nextInt(10) + 1;
        System.out.println("The ANS is : " + answer); // For debugging
        
        int attempts = 0;

        while (true) {
            String guess = JOptionPane.showInputDialog(null, "Guess the Number between 1 to 10 (0 to quit)");

            try {
                //adds to counter and converts guess From String to a integer
                int num1 = Integer.parseInt(guess);
                attempts ++;
                if (num1 == 0) {
                    JOptionPane.showMessageDialog(null, "You gave up! The answer was " + answer);
                    break;
                }

                // Determins if number is Correct or wrong
                if (num1 < answer) {
                    JOptionPane.showMessageDialog(null, "Wrong!!! Your Guess was too Small");
                } else if (num1 > answer) {
                    JOptionPane.showMessageDialog(null, "Wrong!!! Your Guess was too Big");
                } else {
                    JOptionPane.showMessageDialog(null, "Correct! 🎉 " + attempts + " Attempts");
                    break;
                }
                
            //Catch not a number errors
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Must be a number!");
            }
        }
    }
}
