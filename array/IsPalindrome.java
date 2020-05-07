
import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 9
 * 判断一个数是否是回文数
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            int pop = x % 10;
            revertedNumber = revertedNumber * 10 + pop;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        int x = 12321;
        System.out.println(x/10);
    }
}
