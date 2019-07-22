package com.wz.sort;

/**
 * 插入排序 均时间复杂度 O(n*n)
 */
public class InsertionSort {

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 7, 3, 0, 9, 5};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
