package edu.princeton.cs.algs4.leetcode.exercise;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * @author TuFei
 * @date 18-11-23.
 */
class ValidBrackets {
    public boolean isValid(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if ((c == '}' && top != '{')
                        || (c == ']' && top != '[')
                        || (c == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidBrackets validBrackets = new ValidBrackets();
        println(validBrackets.isValid("{{{}}}"));
        println(validBrackets.isValid("{{{}}}}}"));
        println(validBrackets.isValid("{{{{{{{{{}}}}}"));
        println(validBrackets.isValid("[]{}(){[[]()]}"));
        println(validBrackets.isValid("[]{}(){[[(])]}"));
    }
}
