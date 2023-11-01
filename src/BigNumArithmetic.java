import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


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
        //loop through LList and append value into String 's'
        for (int i = string.length() - 1; i > -1; i--) {
            space += string.get(i);
        }
        return space;
    }

    public static String removeZeros(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(0) == '0') {
                s = s.replaceFirst("0", "");
            }
        }
        return s;
    }

    public static String listToString(LList list) {
        String result = "";
        for (int i = 0; i < list.length(); i++) {
            int num = (int)list.getValue();
            list.next();
            result += num;
        }
        result = new StringBuilder(result).reverse().toString();
        return result;
    }
    public static LList stringToList(String s) {
        LList list = new LList();
        for (int i = s.length() - 1; i > -1; i--) {
            int num = Character.getNumericValue(s.charAt(i));
            list.append(num);
        }
        return list;
    }
    //Perform multiplication and subtraction below
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java BigNumArithmetic <input-file>");
            System.exit(1);
        }
        String inputFile = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the RPN
                // Implement the stack-based
                // Handle errors
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}