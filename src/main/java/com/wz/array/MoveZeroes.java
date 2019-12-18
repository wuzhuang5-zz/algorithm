package com.wz.array;

/**
 * leetcode 283
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] arr) {
        int temp = 0;
        for(int i=0,j=0; i<arr.length; i++) {
            if(arr[i] != 0){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }
}
