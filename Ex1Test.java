
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import assignments.ex1.Ex1;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import assignments.ex1.Ex1;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits.
 */


public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2"; // a string representing a number 1011b2 in base-2 (binary).
        int v = Ex1.number2Int(s2); // converts the string 1011b2 from base-2 to its decimal value.
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i++) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] notGood = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < notGood.length; i++) {
            boolean notOk = Ex1.isNumber(notGood[i]);
            assertFalse(notOk);
        }
    }

    @Test
    void isNumberTest() {
        // Test valid numbers in different bases
        String[] validNumbers = {
                "1",       // Base-10: valid single digit number
                "1b2",     // Base-2: valid binary number
                "01b2",    // Base-2: valid binary number with leading zero
                "123bA",   // Base-16: valid hexadecimal number
                "ABbG",    // Base-16: valid hexadecimal number with letters
                "0bA"      // Base-16: valid hexadecimal number with a "0b" prefix
        };

        for (String num : validNumbers) {
            assertTrue(Ex1.isNumber(num), "Expected " + num + " to be valid, but it was not.");
        }

        // Test invalid numbers
        String[] invalidNumbers = {
                "b2",      // Invalid, doesn't start with a number
                "2b2",     // Invalid, invalid format for base 2
                "1G3bG",   // Invalid, contains invalid characters for base
                " BbG",    // Invalid, has leading space
                "0bbA",    // Invalid, has an extra "b" in the middle
                "abB",     // Invalid, characters are not valid in any number format
                "!@b2",    // Invalid, contains non-numeric symbols
                "A",       // Invalid, single letter without a base prefix
                "1bb2"     // Invalid, "bb" is not a valid base notation
        };

        for (String num : invalidNumbers) {
            assertFalse(Ex1.isNumber(num), "Expected " + num + " to be invalid, but it was not.");
        }
    }

    @Test
    void maxIndexTest() {
        // Array of numbers as strings
        String[] numbers = {"123b4", "100b2", "111b2", "46b10", "123b4"};

        // Find the index of the largest number
        int maxIndex = Ex1.maxIndex(numbers);

        // The expected largest value is 123b4 (which is 27 in decimal)
        // So, we expect maxIndex to return 0 (the first index of the largest value)
        assertEquals(0, maxIndex, "Expected the index of the largest value to be 0.");

        // Now testing with another set of numbers where the maximum value should be at index 2
        String[] numbers2 = {"123b4", "123b4", "46bC", "509bC"};

        // The largest value is 509bC, which is at index 3
        int maxIndex2 = Ex1.maxIndex(numbers2);

        // We expect the index of the largest value (509bC) to be 3
        assertEquals(3, maxIndex2, "Expected the index of the largest value to be 3.");

        // Testing case where multiple elements are equal, expecting the first occurrence
        String[] numbers3 = {"123b4", "123b4", "123b4", "123b4"};

        // All numbers are the same, so maxIndex should return the first index (0)
        int maxIndex3 = Ex1.maxIndex(numbers3);

        assertEquals(0, maxIndex3, "Expected the index of the largest value to be 0 (first occurrence).");

        // Test case where the array has a mix of valid and invalid values (should ignore invalid numbers)
        String[] numbers4 = {"123b4", "invalid", "100b2", "xyz", "111b2"};

        // The largest valid number here is 123b4 (which is 27 in decimal)
        // So, we expect maxIndex to return the index of the first occurrence of 123b4, which is 0
        int maxIndex4 = Ex1.maxIndex(numbers4);

        assertEquals(0, maxIndex4, "Expected the index of the largest valid value to be 0.");
    }
}
