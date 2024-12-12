
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
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */

    public static int number2Int(String num) {
        if (num == null || num.length() == 0) {
            return -1;
        }

        // Check for negative numbers or decimals
        if (num.contains("-") || num.contains(".")) {
            return -1;
        }

        int bPosition = num.indexOf('b');
        if (bPosition == -1) {  // no 'b', treat as base 10
            for (char c : num.toCharArray()) {
                if (!((c >= '0' && c <= '9') ||    // not a digit
                        (c >= 'A' && c <= 'G'))) {    // not A-G
                    return -1;
                }
            }
            return -1;  // placeholder for now
        }

        // Check if 'b' is at start or end
        if (bPosition == 0 || bPosition == num.length() - 1) {
            return -1;
        }

        return -1;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String a) {  // Changed from isValidHex and input to isNumber and a
        if (a == null || a.length() == 0) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!((c >= '0' && c <= '9') ||  // checks for 0-9
                    (c >= 'A' && c <= 'G'))) { // checks for A-G
                return false;
            }
        }
        return true;
    }




    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */

    public static String int2Number(int num, int base) {
        String ans = "";

        // Check invalid cases
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        // Handle 0 case
        if (num == 0) {
            return "0";
        }

        // Convert number to new base
        while (num > 0) {
            int remainder = num % base;
            // Convert remainder to character (0-9 or A-F)
            if (remainder < 10) {
                ans = remainder + ans;
            } else {
                char digit = (char)('A' + (remainder - 10));
                ans = digit + ans;
            }
            num = num / base;
        }

        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        // Convert both numbers to decimal (int)
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);

        // If either number was invalid (-1), return false
        if (num1 == -1 || num2 == -1) {
            return false;
        }

        // Compare the decimal values
        return num1 == num2;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */

    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxValue = number2Int(arr[0]);  // Start with first element

        for(int i = 1; i < arr.length; i++) {
            int currentValue = number2Int(arr[i]);
            // Only update if current value is valid (-1 means invalid)
            // and larger than our current max
            if(currentValue != -1 && currentValue > maxValue) {
                maxValue = currentValue;
                ans = i;
            }
        }

        return ans;
    }
}
