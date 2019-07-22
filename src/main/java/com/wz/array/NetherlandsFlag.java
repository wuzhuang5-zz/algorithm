package com.wz.array;

/**
 * 荷兰国旗问题
 * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，
 * 要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，等于K的元素放到数组的中间
 */
public class NetherlandsFlag {

    public static void partition(int[] arr, int l, int r, int k) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < k) {
                swap(arr, ++less, l++);
            } else if (arr[l] > k) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 5, 1, 2, 3, 1, 9, 4, 0, 5};
        partition(arr, 0, arr.length-1, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
