package com.wz.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        spilt(arr, 0, arr.length-1);
    }
    /**
     * 拆分
     */
    private static void spilt(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l+(r-l)/2;
            spilt(arr, l, mid);
            spilt(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    /**
     * 归并
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //拷贝数组
        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 7, 3, 0, 9, 5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
