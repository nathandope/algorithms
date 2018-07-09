package dope.nathan.algorithms.data_structures.module1.task4;

import java.io.*;
import java.util.Stack;

public class Solution {

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());

        Stack<Integer> maxStack = new Stack<>(); // стек с поддержкой максимума
        StringBuilder result = new StringBuilder();

        for (; q > 0; q--) {
            String[] req = reader.readLine().split(" ");
            switch (req[0]) {
                case "push":
                    if (maxStack.empty() ||
                            (Integer.valueOf(req[1]) > maxStack.peek())) {
                        maxStack.push(Integer.valueOf(req[1]));
                    } else {
                        maxStack.push(maxStack.peek());
                    }
                    break;
                case "pop":
                    if (!maxStack.empty()) maxStack.pop();
                    break;
                case "max":
                    if (!maxStack.empty()) result.append(maxStack.peek()).append("\n");
                    break;
            }
        }
        reader.close();
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}