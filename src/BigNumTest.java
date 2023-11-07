
import static org.junit.Assert.*;

import org.junit.Test;

public class BigNumTest {

    @Test
    public void testAdd() {
        LList num1 = new LList();
        LList num2 = new LList();
        LList result = new LList();

        num1 = BigNumArithmetic.stringToList("1279");
        num2 = BigNumArithmetic.stringToList("523");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("1802", BigNumArithmetic.listToString(result));

        // Test Case 2: Unequal List Lengths
        num1 = BigNumArithmetic.stringToList("123");
        num2 = BigNumArithmetic.stringToList("4567");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("4690", BigNumArithmetic.listToString(result));

// Test Case 3: Empty Lists
        num1 = new LList();
        num2 = new LList();
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("", BigNumArithmetic.listToString(result));

// Test Case 4: Carry-Over
        num1 = BigNumArithmetic.stringToList("999");
        num2 = BigNumArithmetic.stringToList("1");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("1000", BigNumArithmetic.listToString(result));

// Test Case 5: Leading Zeroes
        num1 = BigNumArithmetic.stringToList("012");
        num2 = BigNumArithmetic.stringToList("003");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("15", BigNumArithmetic.listToString(result));

// Test Case 7: Large Numbers
        num1 = BigNumArithmetic.stringToList("9999999");
        num2 = BigNumArithmetic.stringToList("1");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("10000000", BigNumArithmetic.listToString(result));


    }

    @Test
    public void testMultiply(){

        LList num1 = new LList();
        LList num2 = new LList();
        LList result = new LList();

        num1 = BigNumArithmetic.stringToList("12");
        num2 = BigNumArithmetic.stringToList("12");
        result = BigNumArithmetic.multiply(num1, num2);
        assertEquals("144", BigNumArithmetic.listToString(result));

        num1 = BigNumArithmetic.stringToList("10");
        num2 = BigNumArithmetic.stringToList("8");
        result = BigNumArithmetic.multiply(num1, num2);
        assertEquals("80", BigNumArithmetic.listToString(result));

        num1 = BigNumArithmetic.stringToList("2");
        num2 = BigNumArithmetic.stringToList("8");
        result = BigNumArithmetic.multiply(num1, num2);
        assertEquals("16", BigNumArithmetic.listToString(result));

        num1 = BigNumArithmetic.stringToList("0002");
        num2 = BigNumArithmetic.stringToList("20");
        result = BigNumArithmetic.multiply(num1, num2);
        assertEquals("40", BigNumArithmetic.listToString(result));





    }
    @Test
    public void testSubtract() {
        LList num1 = new LList();
        LList num2 = new LList();
        LList result = new LList();

        num1 = BigNumArithmetic.stringToList("1279");
         num2 = BigNumArithmetic.stringToList("523");
         result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("756", BigNumArithmetic.listToString(result));

        // Test subtraction with leading zeros
        num1 = BigNumArithmetic.stringToList("001005");
        num2 = BigNumArithmetic.stringToList("509");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("496", BigNumArithmetic.listToString(result));

        // Test subtraction with unequal lengths
        num1 = BigNumArithmetic.stringToList("12345");
        num2 = BigNumArithmetic.stringToList("678");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("11667", BigNumArithmetic.listToString(result));


        num1 = BigNumArithmetic.stringToList("9");
        num2 = BigNumArithmetic.stringToList("8");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("1", BigNumArithmetic.listToString(result));

        num1 = BigNumArithmetic.stringToList("9");
        num2 = BigNumArithmetic.stringToList("9");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("0", BigNumArithmetic.listToString(result));


        num1 = BigNumArithmetic.stringToList("25");
        num2 = BigNumArithmetic.stringToList("29");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("4", BigNumArithmetic.listToString(result));

        // Test subtraction with borrow
        num1 = BigNumArithmetic.stringToList("856");
        num2 = BigNumArithmetic.stringToList("956");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("100", BigNumArithmetic.listToString(result));
    }
    @Test
    public void testRemoveZeros() {
        assertEquals("12345", BigNumArithmetic.removeZeros("000012345"));
        assertEquals("0", BigNumArithmetic.removeZeros("0"));
        assertEquals("12345", BigNumArithmetic.removeZeros("12345"));
        assertEquals("0", BigNumArithmetic.removeZeros("0000"));
    }

    @Test
    public void testListToString() {
        LList list1 = new LList();
        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.append(5);
        assertEquals("54321", BigNumArithmetic.listToString(list1));

        LList list2 = new LList();
        list2.append(0);
        list2.append(0);
        list2.append(0);
        list2.append(0);
        assertEquals("0000", BigNumArithmetic.listToString(list2));
    }

    @Test
    public void testStringToList() {
        LList list1 = BigNumArithmetic.stringToList("12345");
        assertEquals(5, list1.length());
        assertEquals(5, list1.get(0));
        assertEquals(4, list1.get(1));
        assertEquals(3, list1.get(2));
        assertEquals(2, list1.get(3));
        assertEquals(1, list1.get(4));

        LList list2 = BigNumArithmetic.stringToList("0");
        assertEquals(1, list2.length());
        assertEquals(0, list2.get(0));
    }
    @Test
    public void testEvaluateRPN() {
        // Test a simple addition
        LList result1 = BigNumArithmetic.evaluateRPN("2 3 +");
        assertEquals("5", BigNumArithmetic.listToString(result1));

        // Test a simple multiplication
        LList result2 = BigNumArithmetic.evaluateRPN("2 3 *");
        assertEquals("6", BigNumArithmetic.listToString(result2));

        // Test a simple subtraction
        LList result3 = BigNumArithmetic.evaluateRPN("3 2 -");
        assertEquals("1", BigNumArithmetic.listToString(result3));

        // Test  2 * (3 + 4)
        LList result4 = BigNumArithmetic.evaluateRPN("2 3 4 + *");
        assertEquals("14", BigNumArithmetic.listToString(result4));

        LList result5 = BigNumArithmetic.evaluateRPN("44 55 -");
        assertEquals("11", BigNumArithmetic.listToString(result5));


    }
    @Test
    public void testIsLess() {
        // Test case 1: list1 and list2 are equal
        LList list1a = BigNumArithmetic.stringToList("12345");
        LList list2a = BigNumArithmetic.stringToList("12345");
        boolean result1 = BigNumArithmetic.isLess(list1a, list2a);
        assertEquals(false, result1);

        // Test case 2: list1 is less than list2
        LList list1b = BigNumArithmetic.stringToList("12345");
        LList list2b = BigNumArithmetic.stringToList("12346");
        boolean result2 = BigNumArithmetic.isLess(list1b, list2b);
        assertEquals(true, result2);

        // Test case 3: list1 is greater than list2
        LList list1c = BigNumArithmetic.stringToList("12346");
        LList list2c = BigNumArithmetic.stringToList("12345");
        boolean result3 = BigNumArithmetic.isLess(list1c, list2c);
        assertEquals(false, result3);

        // Test case 4: list1 is less than list2 due to shorter length
        LList list1d = BigNumArithmetic.stringToList("123");
        LList list2d = BigNumArithmetic.stringToList("12345");
        boolean result4 = BigNumArithmetic.isLess(list1d, list2d);
        assertEquals(true, result4);
    }
    }

