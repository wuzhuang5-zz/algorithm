package com.wz.array;

/**
 * @Author: wz
 * @Date: 2019/10/29 4:07 下午
 */
public class Solution {
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length == 0)
            return;
        for(int i = 0; i<offset; i++) {
            char c = str[0];
            str[0] = str[str.length-1];
            for(int j= str.length-2; j>=0; j--) {
                    str[j+1] = str[j];
            }
            str[1] = c;
        }
        System.out.println(new String(str));
    }
    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'e', 'f', 'g'};
        rotateString(str, 1);
    }
}
