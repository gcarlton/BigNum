import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class BigNumTest {

    @Test
    public void addTest() {
        BigNumArithmetic bn = new BigNumArithmetic();
        //create 2 LLists to be added
        LList a = new LList();
        LList b = new LList();
        //append values to LLists
        a.append(9);
        a.append(9);
        b.append(1);

        assertEquals("100", bn.toString(bn.add(a, b)));

        a.clear();
        b.clear();

        a.append(9);
        a.append(9);
        a.append(9);

        b.append(1);
        assertEquals("1000", bn.toString(bn.add(a, b)));

        a.clear();
        b.clear();
        a.append(4);
        a.append(3);
        a.append(2);
        a.append(1);

        b.append(0);
        b.append(0);


        assertEquals("1234", bn.toString(bn.add(a, b)));

        a.clear();
        b.clear();
        a.append(0);
        assertEquals("0", bn.toString(bn.add(a, b)));
    }
    @Test
    public void testAdd() {
        LList num1 = new LList();
        LList num2 = new LList();
        LList result = new LList();

        num1 = BigNumArithmetic.stringToList("1279");
        num2 = BigNumArithmetic.stringToList("523");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("1802", BigNumArithmetic.listToString(result), "addition of postive numbers");

        // Test Case 2: Unequal List Lengths
        num1 = BigNumArithmetic.stringToList("123");
        num2 = BigNumArithmetic.stringToList("4567");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("4690", BigNumArithmetic.listToString(result), "Addition with unequal list lengths");

// Test Case 3: Empty Lists
        num1 = new LList();
        num2 = new LList();
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("", BigNumArithmetic.listToString(result), "Addition with empty lists");

// Test Case 4: Carry-Over
        num1 = BigNumArithmetic.stringToList("999");
        num2 = BigNumArithmetic.stringToList("1");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("1000", BigNumArithmetic.listToString(result), "Addition with carry-over");

// Test Case 5: Leading Zeroes
        num1 = BigNumArithmetic.stringToList("012");
        num2 = BigNumArithmetic.stringToList("003");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("015", BigNumArithmetic.listToString(result), "Addition with leading zeroes");

// Test Case 7: Large Numbers
        num1 = BigNumArithmetic.stringToList("9999999");
        num2 = BigNumArithmetic.stringToList("1");
        result = BigNumArithmetic.add(num1, num2);
        assertEquals("10000000", BigNumArithmetic.listToString(result), "Addition of large numbers");


    }
    @Test
    public void testSubtract() {
        LList num1 = new LList();
        LList num2 = new LList();
        LList result = new LList();

        num1 = BigNumArithmetic.stringToList("1279");
         num2 = BigNumArithmetic.stringToList("523");
         result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("0756", BigNumArithmetic.listToString(result), "Subtraction of positive numbers");

        // Test subtraction with leading zeros
        num1 = BigNumArithmetic.stringToList("1005");
        num2 = BigNumArithmetic.stringToList("509");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("0496", BigNumArithmetic.listToString(result), "Subtraction with leading zeros");

        // Test subtraction with unequal lengths
        num1 = BigNumArithmetic.stringToList("12345");
        num2 = BigNumArithmetic.stringToList("678");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("11667", BigNumArithmetic.listToString(result), "Subtraction with unequal lengths");

        // Test subtraction with borrow
        num1 = BigNumArithmetic.stringToList("856");
        num2 = BigNumArithmetic.stringToList("956");
        result = BigNumArithmetic.subtract(num1, num2);
        assertEquals("100", BigNumArithmetic.listToString(result), "Subtraction with borrow");
    }
    }

