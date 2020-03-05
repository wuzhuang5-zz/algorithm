import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0 && nums[j] > nums[j+1] ; j--) {
                swap(nums, j, j + 1);
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
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

