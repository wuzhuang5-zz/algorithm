package com.wz.sort;

/**
 * 快排
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        split(arr, 0, arr.length-1);
    }

    /**
     * 递归重复partition操作  拆分
     * @param arr
     * @param l
     * @param r
     */
    private static void split(int[] arr, int l, int r) {
        if(l < r) {
            int[] p = partition(arr, l, r);
            split(arr, l, p[0]-1);
            split(arr, p[1]+1, r);
        }
    }

    /**
     * 以less+1  more为中心左边小右边大
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, more--, l);
            } else {
                l++;
            }
        }
        return new int[]{less+1, more};
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 7, 3, 0, 9, 5, 5};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
