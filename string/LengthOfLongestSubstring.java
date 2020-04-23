import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 3
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int strlen = s.length();
        if (strlen < 2) {
            return strlen;
        }
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < strlen || j < strlen) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(i++);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcabcdbb";
        int longLength = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(longLength);
    }
}