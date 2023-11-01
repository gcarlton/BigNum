import java.util.ArrayList;
import java.util.List;

public class LStack implements Stack {
    private List<String> stack;
    private int size;
    // Constructor to initialize an empty stack
    LStack() {
        stack = new ArrayList<>();
        size = 0;
    }

    // Clear the stack by removing all elements
    public void clear() {
        stack.clear();
        size = 0;
    }

    // Push an element onto the top of the stack
    public boolean push(Object it) {
        // Ensure that the element is a String before adding it to the stack
        if (it instanceof String) {
            stack.add((String) it);
            size++;
            return true;
        }
        return false; // Only accept Strings
    }

    // Remove and return the element at the top of the stack
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return stack.remove(size);
    }

    // Return a copy of the top element without removing it
    public Object topValue() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(size - 1);
    }

    // Return the number of elements in the stack
    public int length() {
        return size;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }
}