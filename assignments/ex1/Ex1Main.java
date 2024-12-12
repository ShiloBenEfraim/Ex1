package assignments.ex1;

import java.util.Scanner;
import assignments.ex1.Ex1;


public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";

        // Start the main loop to keep accepting input until "quit" is entered
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Prompt for num1
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            

            if (!num1.equals(quit)) {
                // Validate num1
                if (Ex1.isNumber(num1)) {
                    // Convert num1 to decimal
                    int decimal1 = Ex1.number2Int(num1);
                    System.out.println("num1 = " + num1 + " is number: true , value: " + decimal1);
                } else {
                    System.out.println("num1 = " + num1 + " is number: false , value: -1");

                }
            }

            // Prompt for num2 (only if num1 is not "quit")
            if (!num1.equals(quit)) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    // Validate num2
                    if (Ex1.isNumber(num2)) {
                        // Convert num2 to decimal
                        int decimal2 = Ex1.number2Int(num2);
                        System.out.println("Number #2 in decimal: " + decimal2);

                        // Compare num1 and num2
                        if (Ex1.equals(num1, num2)) {
                            System.out.println("Both numbers are equal.");
                        } else {
                            System.out.println("Numbers are not equal.");
                        }
                    } else {
                        System.out.println("Invalid input for number #2.");
                    }
                }
            }
        }

        // Program exits when either num1 or num2 is "quit"
        System.out.println("Quitting now...");
        sc.close();  // Close the scanner to prevent resource leak
    }
}
