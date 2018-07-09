package dope.nathan.algorithms.data_structures.module1.task1;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        Stack<Character> bracketsStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        int count = 0;
        for (char aChar : s.toCharArray()) {
            count++;
            if ((aChar == '(') || (aChar == '[') || (aChar =='{')){
                bracketsStack.push(aChar);
                countStack.push(count);
            } else if ((aChar == ')') || (aChar == ']') || (aChar =='}')) {
                if (bracketsStack.empty()) {
                    System.out.println(count);
                    return;
                }

                char top = bracketsStack.pop();
                countStack.pop();

                if ((top == '{' && aChar != '}') ||
                        (top == '[' && aChar != ']') ||
                        (top == '(' && aChar != ')')) {
                    System.out.println(count);
                    return;
                }
            } else {
                countStack.push(count);
            }
        }

        if (bracketsStack.empty() && (count == s.length())) {
            System.out.println("Success");
        } else {
            System.out.println(countStack.pop());
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}