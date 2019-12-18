package com.wz.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode  17
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 * 回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，
 * 回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
 *
 */
public class LetterCombinations {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        List<String> output = new ArrayList<String>();

        public void backtrack(String combination, String next_digits) {
            // if there is no more digits to check
            if (next_digits.length() == 0) {
                // the combination is done
                output.add(combination);
            }
            // if there are still digits to check
            else {
                // iterate over all letters which map
                // the next available digit
                String digit = next_digits.substring(0, 1);
                String letters = phone.get(digit);
                for (int i = 0; i < letters.length(); i++) {
                    String letter = phone.get(digit).substring(i, i + 1);
                    // append the current letter to the combination
                    // and proceed to the next digits
                    backtrack(combination + letter, next_digits.substring(1));
                }
            }
        }
        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0) {
                backtrack("", digits);
            }
            return output;
        }
}
