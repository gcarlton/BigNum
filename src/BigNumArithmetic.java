import java.io.*;
import java.util.Stack;



public class BigNumArithmetic {
    // Method to perform addition of two numbers that are in linked lists
    public static LList add(LList list1, LList list2) {
        // Make sure both input lists have the same length by appending leading zeros
        if (list1.length() > list2.length()) {
            int lengthDifference = list1.length() - list2.length();
            for (int i = 0; i < lengthDifference; i++) {
                list2.append(0);
            }
        } else {
            int lengthDifference = list2.length() - list1.length();
            for (int i = 0; i < lengthDifference; i++) {
                list1.append(0);
            }
        }
        // Initialize pointers for list1 and list2
        list1.moveToStart();
        list2.moveToStart();
        // Create a linked list to store the final result
        LList finalResult = new LList();
        int carry = 0;

        // Loop through the digits of list1 and list2 performing addition
        for (int i = 0; i < list1.length(); i++) {
            int digit1 = (int) list1.getValue();
            int digit2 = (int) list2.getValue();
            int currentSum = digit1 + digit2 + carry;
            // Handle carry when the current sum is greater than 9
            if (currentSum > 9) {
                carry = 1;
                currentSum -= 10;
                finalResult.append(currentSum);
            } else {
                carry = 0;
                finalResult.append(currentSum);
            }
            // Move to the next digits in both lists
            list1.next();
            list2.next();
        }
        // If there is a remaining carry append it to the result
        if (carry == 1) {
            finalResult.append(carry);
        }
        // Convert the result to a string, remove leading zeros and convert it back to a linked list
        String s = listToString(finalResult);
        s = removeZeros(s);
        finalResult = stringToList(s);
        // Return the final result
        return finalResult;
    }

    // This method removes leading zeros from a string.
    public static String removeZeros(String y) {
        int x = 0;
        while (x < y.length() - 1 && y.charAt(x) == '0') {
            x++;
        }
        return y.substring(x);
    }

    // This method converts a linked list of digits to a string.
    public static String listToString(LList list) {
        String y = "";
        for (int i = 0; i < list.length(); i++) {
            int num = (int) list.getValue();
            list.next();
            y += num;
        }
        y = new StringBuilder(y).reverse().toString();
        return y;
    }

    // This method converts a string of digits to a linked list.
    public static LList stringToList(String y) {
        LList list = new LList();
        for (int i = y.length() - 1; i > -1; i--) {
            int x = Character.getNumericValue(y.charAt(i));
            list.append(x);
        }
        return list;
    }

    //Method to perform subtraction of two numbers that are in linked lists
    public static LList subtract(LList list1, LList list2) {
        // Check if list1 is smaller than list2 based on lengths
        if (list1.length() < list2.length()) {
            // Swap list1 and list2
            LList temp = list1;
            list1 = list2;
            list2 = temp;
        } else if (list1.length() == list2.length()) {
            // If lengths are equal, iterate through the lists to find the greater number
            list1.moveToStart();
            list2.moveToStart();
            while (list1.currPos() < list1.length()) {
                int digit1 = (int) list1.getValue();
                int digit2 = (int) list2.getValue();
                if (digit1 < digit2) {
                    // Swap list1 and list2
                    LList temp = list1;
                    list1 = list2;
                    list2 = temp;
                } else if (digit1 > digit2) {
                    // list1 is greater, no need to swap
                    break; // No need to continue checking
                }
                list1.next();
                list2.next();
            }
        }
        // Check if list1 is longer than list2
        if (list1.length() > list2.length()) {
            // Calculate the difference in length between list1 and list2
            int lengthDifference = list1.length() - list2.length();
            // Pad list2 with leading zeros to match the length of list1
            for (int i = 0; i < lengthDifference; i++) {
                list2.append(0);
            }
        } else {
            // Calculate the difference in length between list2 and list1
            int lengthDifference = list2.length() - list1.length();
            // Pad list1 with leading zeros to match the length of list2
            for (int i = 0; i < lengthDifference; i++) {
                list1.append(0);
            }
        }
        list1.moveToStart();
        list2.moveToStart();
        LList finalResult = new LList();
        int borrow = 0;
        for (int i = 0; i < list1.length(); i++) {
            int digit1 = (int) list1.getValue();
            int digit2 = (int) list2.getValue() + borrow;
            if (digit1 < digit2) {
                borrow = 1;
                digit1 += 10;
            } else {
                borrow = 0;
            }
            int currentDifference = digit1 - digit2;
            finalResult.append(currentDifference);
            list1.next();
            list2.next();
        }
        String s = listToString(finalResult);
        s = removeZeros(s);
        finalResult = stringToList(s);

        return finalResult;
    }
    //Method to perform multiplication of two numbers that are in linked lists
    public static LList multiply(LList list1, LList list2) {
        // Ensure both input lists have the same length by appending leading zeros if needed
        if (list1.length() > list2.length()) {
            int diff = (list1.length() - list2.length());
            for (int i = 0; i < diff; i++) {
                list2.append(0);
            }
        } else {
            int diff = (list2.length() - list1.length());
            for (int i = 0; i < diff; i++) {
                list1.append(0);
            }
        }
        // Initialize pointers for list1 and list2
        list1.moveToStart();
        list2.moveToStart();
        // Create linked lists for finalNum and answer
        LList finalNum = new LList();
        LList answer = new LList();
        // Initialize a variable to keep track of carry digits
        int carry = 0;
        // Loop through the digits of list1
        for (int i = 0; i < list1.length(); i++) {
            // Append leading zeros in the answer to align with the current digit
            for (int x = 0; x < i; x++) {
                answer.append(0);
            }
            // Get the current digit from list1
            int get = (int) list1.getValue();
            // Loop through the digits of list2 for multiplication
            for (int j = 0; j < list2.length(); j++) {
                // If it's the first iteration in the inner loop, reset list2 pointer
                if (j == 0) {
                    list2.moveToStart();
                }
                // Get the current digit from list2
                int get2 = (int) list2.getValue();
                // Perform digit-wise multiplication and consider the carry
                int combine = (get2 * get) + carry;
                // Handle carry when the result is greater than 9
                if (combine > 9) {
                    carry = (combine / 10);
                    answer.append(combine % 10);
                } else if ((get2 * get) == 0 && combine > 0) {
                    // Handle carry when the result is not zero but not greater than 9
                    answer.append(carry);
                    carry = 0;
                } else if ((get2 * get) != 0 && combine > 0) {
                    // Handle carry when the result is not zero and greater than 9
                    answer.append(combine);
                    carry = 0;
                } else {
                    answer.append(combine);
                }
                list2.next();
            }
            // Add any remaining carry to the answer
            if (carry != 0) {
                answer.append(carry);
                carry = 0;
            }
            // Perform addition of the multiplication result to the finalNum
            finalNum = add(answer, finalNum);
            // Convert finalNum to a string for further processing
            String s = listToString(finalNum);
            // Remove leading zeros from the string
            s = removeZeros(s);
            // Convert the modified string back to a linked list
            finalNum = stringToList(s);
            // Clear the answer list for the next iteration
            answer.clear();
            // Move to the next digit in list1
            list1.next();
        }
        // Return the final result
        return finalNum;
    }
    //Method that does the RPN calculator
    public static LList evaluateRPN(String expression) {
        Stack<LList> stack = new Stack<>();
        String[] t = expression.split("\\s+");

        for (String token : t) {
            token = token.trim(); // Remove leading/trailing spaces
            if (token.matches("\\d+")) {
                // Operand, convert to LList and push to the stack
                String op = removeZeros(token);
                LList x = stringToList(op);
                stack.push(x);
            } else if (token.equals("+") || token.equals("*") || token.equals("-")) {
                // Operator, pop the required number of operands and perform the operation
                if (stack.size() < 2) {
                    return new LList();
                }
                LList op2 = stack.pop();
                LList op1 = stack.pop();

                if (token.equals("+")) {
                    stack.push(add(op1, op2));
                } else if (token.equals("*")) {
                    // Implement multiplication
                    stack.push(multiply(op1, op2));
                } else if (token.equals("-")) {
                    // Implement subtraction
                     stack.push(subtract(op1, op2));
                }
            } else {
                return new LList();
            }
        }

        if (stack.size() != 1) {
            return new LList();

        }

        return stack.pop();
    }
// Main method to read from command line
    public static void main(String[] args) {
        //String inputFileName = args[0];
        //String inputFileName = "AdditionInput.txt";

        if (args.length > 0) {
            String fileName = args[0];
            File file = new File(fileName);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    try {
                        // Evaluate the expression using evaluateRPN
                        LList result = evaluateRPN(line);
                        // Print the original expression
                        System.out.print(line + " = ");
                        // Convert and print the result
                        System.out.println(listToString(result));
                    } catch (Exception e) {
                        // Handle any exceptions and print an error message
                        System.out.println(line + " = Error: " + e.getMessage()); // Print an error message
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the input file: " + e.getMessage());
            }
        }
    }
}





