package com.wz.string;

/**
 * 最长回文子串
 *
 * 示例1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 *
 * 示例2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    //暴力法 两层循环遍历
    public String longestPalindrome(String s) {
        //存储最大回文子串
        String ans = "";
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                String tmp = s.substring(i, j);
                if (isPalindromic(tmp) && tmp.length() > max) {
                    ans = tmp;
                    max = tmp.length();
                }
            }
        }
        return ans;
    }

    /**
     * 判断一个字符串是否是回文
     * @param s
     * @return
     */
    private boolean isPalindromic(String s) {
        int length = s.length();
        for (int i = 0; i < length/2 ; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babadcccc";
        String result = new LongestPalindrome().longestPalindrome(s);
        System.out.println(result);
    }
}
