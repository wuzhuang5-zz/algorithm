import java.util.Arrays;

/**
 * 选择排序  时间复杂度O(n*n)
 */
public class SelectSort {
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 7, 1, 10, 23};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
