package com.wz.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode 20
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {
        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;
        // Initialize hash map with mappings. This simply makes the code easier to read.
        public IsValid() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }
        public boolean isValid(String s) {
            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // If the current character is a closing bracket.
                if (this.mappings.containsKey(c)) {
                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    char topElement = stack.empty() ? '#' : stack.pop();
                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }
            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }
