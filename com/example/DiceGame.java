package com.example;

import java.util.Scanner;
import java.util.Random;

/**
 * This program is a Dice Game from 1 to 6.
 * The user has to guess the random number generated between 1 and 6.
 *
 * @author Tamer
 * @version 1.0
 * @since 2024-03-04
 */
public final class DiceGame {

  // Private constructor to prevent instantiation of the class
  private DiceGame() {
    throw new UnsupportedOperationException("Cannot be instantiated.");
  }

  public static void main(final String[] args) {
    int userNumber; // Variable to store the user's guess
    Scanner sc = new Scanner(System.in); // Scanner object to read user input
    Random randomNum = new Random(); // Random object to generate random numbers

    try {
      // Introduction to the game
      System.out.println("This program is a Dice Game from 1 to 6.");
      System.out.println("Please Enter Your Number: ");
      
      // Get user's input
      userNumber = sc.nextInt();
      
      // Generate a random number between 1 and 6
      int randomValue = randomNum.nextInt(6) + 1;

      int numTrys = 1; // Counter to keep track of the number of tries
      
      // Loop until the user guesses the correct number
      while (userNumber != randomValue) {
        numTrys++; // Increment the try counter
        // Check if the user's input is within the valid range
        if (7 > userNumber && userNumber > 0) {
          // Provide hints to the user based on their input
          if (userNumber > randomValue) {
            System.out.println("Lower");
          } else if ((userNumber < randomValue)) {
            System.out.println("Higher");
          }
        }
        else{
          // Inform the user if the input is out of range
          System.out.println("Must be in range 1 - 6");
          numTrys--; // Decrement the try counter as the invalid try should not be counted
        }
        // Prompt the user to try again
        System.out.print("Try Again: ");
        userNumber = sc.nextInt();
      }
      
      // Display a congratulatory message when the user guesses the correct number
      System.out.println("YOU GUESSED IT CONGRATS!");
      System.out.println("Correct! You guessed the random number in " + numTrys + " Try(s).");

    } catch (Exception e) {
      // Catch any exceptions that may occur during input/output operations
      System.out.println("Error " + e.getMessage());
    } finally {
      // Close the scanner to prevent resource leak
      sc.close();
    }
  }
}
