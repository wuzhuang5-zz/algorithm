package com.wz.array;

/**
 * leetcode 53
 * 最大子序和
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] arr) {
        //存储每次循环的和
        int sum = 0;
        //存储最大的和
        int ans = 0;
        for (int num : arr) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = new MaxSubArray().maxSubArray(arr);
        System.out.println(sum);
    }
}
