package com.wz.dp;

import java.util.List;

/**
 * @Author: wz
 * [
 *      [1],
 *    [2,3],
 *   [4,5,6]
 * ]
 */
public class MinPathTriangle {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int minPath = Integer.MAX_VALUE;
        circle(0, 0, 0, triangle, minPath);
        return minPath;
    }

    public void circle (int x, int y, int sum, List<List<Integer>> triangle, int minPath) {
        if (x == triangle.size()) {
            sum = Math.min(minPath, sum);
        }
        circle(x+1, y, sum + triangle.get(x+1).get(y), triangle, minPath);
        circle(x+1, y+1, sum + triangle.get(x+1).get(y+1), triangle, minPath);
    };
}
