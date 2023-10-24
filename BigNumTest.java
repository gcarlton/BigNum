import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BigNumTest {

    @Test
    public void testAddition() {
        // Test addition of two positive numbers
        assertEquals("5", BigNumArithmetic.performAddition("2", "3"));
        assertEquals("11", BigNumArithmetic.performAddition("8", "3"));
        assertEquals("123556", BigNumArithmetic.performAddition("98765", "24791"));

        // Test addition with leading zeroes
        assertEquals("5", BigNumArithmetic.performAddition("002", "03"));
        assertEquals("1234", BigNumArithmetic.performAddition("0001234", "0000"));

        // Test addition of a number with zero
        assertEquals("12345", BigNumArithmetic.performAddition("12345", "0"));

        // Test addition of large numbers
        assertEquals("1000000000000000000000000000000000000000", BigNumArithmetic.performAddition("999999999999999999999999999999999999999", "1"));
        assertEquals("3141592653589793238462643383279502884197", BigNumArithmetic.performAddition("3141592653589793238462643383279502884196", "1"));
    }
}

