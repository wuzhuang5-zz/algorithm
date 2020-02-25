import java.util.HashSet;
import java.util.Set;

/**
 * 剑指Offer 03 数组中重复的数字
 * 示例：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int item: nums) {
            if(set.contains(item)) {
                return item;
            }
            set.add(item);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 0, 2, 5, 3};
        int result = findRepeatNumber(nums);
        System.out.println(result);
    }
}
