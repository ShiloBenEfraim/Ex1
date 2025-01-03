// Basa"d


/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1_BackUp {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */

    // Converts number to decimal format
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            throw new IllegalArgumentException("Invalid number");
        }
        int bIndex = num.indexOf('b');
        String numberPart = num.substring(0, bIndex);
        String basePart = num.substring(bIndex + 1);
        int base = getBase(basePart); // Number base
        return Integer.parseInt(numberPart); // Convert to decimal
    }

    // Adds two numbers in special format and returns result in this format
    public static String add(String num1, String num2) {
        int dec1 = number2Int(num1); // Convert first number to decimal
        int dec2 = number2Int(num2); // Convert second number to decimal
        int sum = dec1 + dec2; // Perform addition
        return sum + "b10"; // Return result in base 10 format
    }

    // Converts string base to number
    private static int getBase(String baseStr) {
        if (baseStr.length() == 1) {
            char b = baseStr.charAt(0);
            if (Character.isDigit(b)) {
                return b - '0'; // Convert '2'-'9' to numbers
            } else if (b >= 'A' && b <= 'G') {
                return b - 'A' + 10; // Convert 'A'-'G' to 10-16
            }
        }
        throw new IllegalArgumentException("Invalid base");
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String a) {
        if (a == null || a.length() == 0) {
            return false;
        }

        int bPosition = a.indexOf('b');
        if (bPosition == -1) {
            for (char c : a.toCharArray()) {
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
            }
            return true;
        }

        String numberPart = a.substring(0, bPosition);
        String basePart = a.substring(bPosition + 1);

        // check that base is valid
        if (basePart.length() != 1 || numberPart.length() == 0)
            return false;

        char baseChar = basePart.charAt(0);
        boolean isBaseBetween2and9 = '2' <= baseChar && baseChar <= '9';
        boolean isBaseBetweenAandG = 'A' <= baseChar && baseChar <= 'G';
        if (!(isBaseBetween2and9 || isBaseBetweenAandG))
            return false;

        // check that number is valid
        for (char c : numberPart.toCharArray()) {
            boolean isBaseBiggerThanNum = baseChar > c;
            boolean isValidLetter = '0' <= c && c <= '9' || 'A' <= c && c <= 'G';

            if (!(isValidLetter && isBaseBiggerThanNum))
                return false;
        }

        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }

}