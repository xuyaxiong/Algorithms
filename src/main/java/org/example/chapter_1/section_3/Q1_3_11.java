package org.example.chapter_1.section_3;

public class Q1_3_11 {
    public static int evaluatePostfix(String postfix) {
        String[] arr = postfix.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String curr : arr) {
            switch (curr) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        return stack.pop();
    }
}
