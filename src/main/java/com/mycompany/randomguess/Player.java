/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.randomguess;

/**
 *
 * @author evanh
 */
 class Player {

    private String name;
    private int attempts;
        
         public Player(String name){
             this.name = name;
             this.attempts = 0;
    }
         public String getName() {
         return name;
         }
            public int getAttempts(){
            return attempts;
            }
                public void IncrementAttempts(){
                attempts++;
                }
    

}

