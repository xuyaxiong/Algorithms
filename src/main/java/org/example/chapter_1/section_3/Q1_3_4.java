package org.example.chapter_1.section_3;

public class Q1_3_4 {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char curr = str.charAt(i);
            switch (curr) {
                case '(':
                case '[':
                case '{':
                    stack.push(curr);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
