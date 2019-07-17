package com.wz.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static void bubbleSortOptimize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if( arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 7, 3, 0, 9, 5};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
