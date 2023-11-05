import java.io.*;
import java.util.Stack;



public class BigNumArithmetic {
    // Method to perform addition of two numbers
    public static LList add(LList list1, LList list2) {
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
        list1.moveToStart();
        list2.moveToStart();
        LList finalResult = new LList();
        int carry = 0;
        for (int i = 0; i < list1.length(); i++) {
            int digit1 = (int) list1.getValue();
            int digit2 = (int) list2.getValue();
            int currentSum = digit1 + digit2 + carry;
            if (currentSum > 9) {
                carry = 1;
                currentSum -= 10;
                finalResult.append(currentSum);
            } else {
                carry = 0;
                finalResult.append(currentSum);
            }
            list1.next();
            list2.next();
        }
        if (carry == 1) {
            finalResult.append(carry);
        }
        return finalResult;
    }

    public static String toString(LList string) {
        String space = "";
        //loop through LList and append  into string
        for (int i = string.length() - 1; i > -1; i--) {
            space += string.get(i);
        }
        return space;
    }

    public static String removeZeros(String y) {
        int x = 0;
        while (x < y.length() - 1 && y.charAt(x) == '0') {
            x++;
        }
        return y.substring(x);
    }

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

    public static LList stringToList(String y) {
        LList list = new LList();
        for (int i = y.length() - 1; i > -1; i--) {
            int x = Character.getNumericValue(y.charAt(i));
            list.append(x);
        }
        return list;
    }

    //Perform multiplication and subtraction below
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

        return finalResult;
    }


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
                    // stack.push(multiply(op1, op2));
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





