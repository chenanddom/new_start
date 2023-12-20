package com.itdom.recursion.binarysearch;

/**
 * 使用递归实现二分查找
 */
public class BinarySearch {


    public int bf(int[] arr, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        //标识值在中间值的右边
        if (target < arr[m]) {
            return bf(arr, target, i, m - 1);
        } else if (target > arr[m]) {
            return bf(arr, target, m + 1, j);
        } else {
            return m;
        }
    }

}