/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hangmangame;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class hangmanGame {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "orange", "peach", "watermelon"};
        String word = words[(int) (Math.random() * words.length)];
        String answer = new String(new char[word.length()]).replace("\0", "-");
        int attempts = 7;

        while (attempts > 0 && answer.contains("-")) {
            System.out.println("Guess a letter (" + attempts + " attempts left): ");
            System.out.println(answer);
            char guess = scanner.next().charAt(0);

            if (word.contains(String.valueOf(guess))) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        answer = answer.substring(0, i) + guess + answer.substring(i + 1);
                    }
                }
            } else {
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("You lose! The word was " + word);
        } else {
            System.out.println("You win! The word was " + word);
        }
    }
}

    
