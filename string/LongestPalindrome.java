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
    public static String longestPalindrome(String s) {
        //存储最大回文子串
        String ans = "";
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String tmp = s.substring(i, j);
                if (isPalindromic(tmp) && tmp.length() > max) {
                    ans = tmp;
                    max = tmp.length();
                }
            }
        }
        return ans;
    }

    private static boolean isPalindromic(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < length; j++) {
                int end = j + i - 1;
                if (end >= length) {
                    break;
                }
                P[j][end] = (i == 1 || i == 2 || P[j + 1][end - 1]) && s.charAt(j) == s.charAt(end);
                if (P[j][end] && i > maxLen) {
                    maxPal = s.substring(j, end + 1);
                }
            }
        }
        return maxPal;
    }
        public static String longestPalindrome3(String s){
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

    public static String longestPalindrome4(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0,1);
        boolean[][] dp = new boolean[length][length];
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r-l+1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
        public static void main (String[]args){
            String s = "ba";
            String result = longestPalindrome3(s);
            System.out.println(result);
        }
    }

