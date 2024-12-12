package assignments.ex1;

import java.util.Scanner;

import assignments.ex1.Ex1;


import java.util.Scanner;

import assignments.ex1.Ex1;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

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
                    System.out.println("num1= " + num1 + " is number: true , value: " + decimal1);
                } else {
                    System.out.println("num1= " + num1 + " is number: false , value: -1");
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
                        System.out.println("num2= " + num2 + " is number: true , value: " + decimal2);
                    } else {
                        System.out.println("num2= " + num2 + " is number: false , value: -1");
                    }
                }

                // Ask the user for a base
                System.out.println("Enter a base for output: (a number [2,16]) ");
                int base = sc.nextInt();

                if (base < 2 || base > 16) {
                    System.out.println("Invalid base. Please enter a number between 2 and 16.");
                } else {
                    // Convert both num1 and num2 to the new base and perform operations
                    int decimal1 = Ex1.number2Int(num1);
                    int decimal2 = Ex1.number2Int(num2);

                    // Perform addition and multiplication
                    int sum = decimal1 + decimal2;
                    int product = decimal1 * decimal2;

                    // Convert the results to the desired base
                    String sumBase = Ex1.int2Number(sum, base) + "b" + Integer.toHexString(base).toUpperCase();
                    String productBase = Ex1.int2Number(product, base) + "b" + Integer.toHexString(base).toUpperCase();

                    // Print the results
                    System.out.println(num1 + " + " + num2 + " = " + sumBase);
                    System.out.println(num1 + " * " + num2 + " = " + productBase);

                    // Find the maximum number from the list of numbers and convert to the new base
                    String[] numbers = { num1, num2, sumBase, productBase };
                    int maxIndex = Ex1.maxIndex(numbers);
                    String maxNumber = numbers[maxIndex];

                    System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + maxNumber);
                }
            } else {
                System.out.println("Invalid input for number #2.");
            }
        }
        System.out.println("Quitting now...");
        sc.close();  // Close the scanner to prevent resource leak
    }
}


// Program exits when either num1 or num2 is "quit"

