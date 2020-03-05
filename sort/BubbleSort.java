import java.util.Arrays;

/**
 * 冒泡    时间复杂度 O(n*n)
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j + 1);
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
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
