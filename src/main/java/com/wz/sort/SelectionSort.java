package com.wz.sort;

/**
 *
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                min = arr[j] > min ? arr[j] : min;
            }
        }
    }
}
