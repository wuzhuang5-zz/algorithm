package com.bytedance.string;

/**
 * leetcode 5
 * 最长回文子串
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
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

    /**
     * 动态规划   时间复杂度O(n*n)
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "babadcccc";
        String result = new LongestPalindrome().longestPalindrome(s);
        System.out.println(result);
    }
}
