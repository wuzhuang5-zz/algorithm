package com.wz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = target - arr[i];
            if (map.containsKey(tmp)) {
                return new int[]{arr[i], tmp};
            }
            map.put(arr[i], i);
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new TwoSum().twoSum(arr, 17);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

