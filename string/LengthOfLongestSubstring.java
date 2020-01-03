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
        if(s == null || " ".equals(s) || s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int tmp = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            Boolean flag = set.contains(chars[i]);
            if (flag == false) {
                set.add(chars[i]);
            } else {
                tmp = set.size() > tmp ? set.size() : tmp;
                set.clear();
                i = j++;
            }
        }
        int result = tmp > set.size() ?tmp : set.size();
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcdbb";
        int longLength = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(longLength);
    }
}