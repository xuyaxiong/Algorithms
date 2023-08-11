package org.example.chapter_1.section_3;

public class Q1_3_10 {
    public static String infixToPostfix(String infix) {
        Stack<Character> opStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infix.length(); ++i) {
            char curr = infix.charAt(i);
            switch (curr) {
                case '+':
                case '*':
                    opStack.push(curr);
                    break;
                case '(':
                case ' ':
                    break;
                case ')':
                    sb.append(opStack.pop());
                    sb.append(' ');
                    break;
                default:
                    sb.append(curr);
                    sb.append(' ');
                    break;
            }
        }
        return sb.toString().trim();
    }
}
