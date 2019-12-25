/**
 * leetcode 53
 * 最大子序和
 */
public class MaxSubArray {
    public static int maxSubArray(int[] arr) {
        int ans = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(arr);
        System.out.println(result);
    }
}
