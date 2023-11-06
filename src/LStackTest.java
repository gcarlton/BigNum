import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LStackTest {

    @Test
    public void testPushAndPop() {
        LStack stack = new LStack();
        assertTrue(stack.isEmpty());

        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testTopValue() {
        LStack stack = new LStack();
        assertNull(stack.topValue());

        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.topValue());
        stack.pop();
        assertEquals("a", stack.topValue());
    }

    @Test
    public void testLength() {
        LStack stack = new LStack();
        assertEquals(0, stack.length());

        stack.push("One");
        assertEquals(1, stack.length());

        stack.push("Two");
        stack.push("Three");
        assertEquals(3, stack.length());

        stack.pop();
        assertEquals(2, stack.length());

        stack.pop();
        stack.pop();
        assertEquals(0, stack.length());
    }

    @Test
    public void testClear() {
        LStack stack = new LStack();
        stack.push("a");
        stack.push("b");
        stack.clear();
        assertTrue(stack.isEmpty());
    }
}