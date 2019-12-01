package com.wz.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wz
 * [
 *      [1],
 *      [2,3],
 *      [8,5,2]
 * ]
 */
public class MinPathTriangle {
    private Integer[][] stash;
    /**
     * 递归
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return reverse(0, 0, triangle);
    }
    private int reverse(int x, int y, List<List<Integer>> triangle) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        int left = reverse(x + 1, y, triangle);
        int right = reverse(x + 1, y + 1, triangle);
        return Math.min(left, right) + triangle.get(x).get(y);
    }

    /**
     * 改进递归，避免重复计算
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        stash = new Integer[triangle.size()][triangle.size()];
        return reverse2(0, 0, triangle);
    }
    private int reverse2(int x, int y, List<List<Integer>> triangle) {
        if (x == triangle.size() - 1) {
            stash[x][y] = triangle.get(x).get(y);
        }
        if (stash[x][y] != null) {
            return stash[x][y];
        }

        int left = reverse2(x + 1, y, triangle);
        int right = reverse2(x + 1, y + 1, triangle);
        stash[x][y] = Math.min(left, right) + triangle.get(x).get(y);
        return stash[x][y];
    }

    /**
     * 动态规划   自底向上
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int rows = triangle.size() - 1;
        int[] dp = new int[triangle.size() + 1];
        for (int x = rows; x >= 0; x--) {
            for (int i = 0; i <= x; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(x).get(i);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list2.add(2);
        list2.add(3);
        list3.add(8);
        list3.add(5);
        list3.add(2);
        list.add(list1);
        list.add(list2);
        list.add(list3);

        int minLength = new MinPathTriangle().minimumTotal3(list);
        System.out.println(minLength);
    }
}
