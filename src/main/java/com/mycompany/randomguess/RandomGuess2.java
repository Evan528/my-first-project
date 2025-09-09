/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomguess;

import java.util.Random;
import javax.swing.JOptionPane;

public class RandomGuess2 {
    public static void main(String[] args) {

        // Generates the number and displays ANS  
        Random num = new Random();
        int answer = num.nextInt(10) + 1;
        System.out.println("The ANS is : " + answer); // For debugging
        
   
      
            String guess = JOptionPane.showInputDialog(null, "Guess the Number between 1 to 10 (0 to quit)");

           
                int num1 = Integer.parseInt(guess);
           
                if (num1 == 0) {
                    JOptionPane.showMessageDialog(null, "You gave up! The answer was " + answer);
                 
                }

                if (num1 < answer) {
                    JOptionPane.showMessageDialog(null, "Wrong!!! Your Guess was too Small");
                } else if (num1 > answer) {
                    JOptionPane.showMessageDialog(null, "Wrong!!! Your Guess was too Big");
                } else {
                    JOptionPane.showMessageDialog(null, "Correct! 🎉 " );
               
                }

            
             
            }
        
    
}