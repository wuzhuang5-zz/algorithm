import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字  面试题03
 * 找出数组中重复的数字
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            if (set.contains(item)) {
                return item;
            }
            set.add(item);
        }
        return -1;
    }
}
