package com.itdom.recursion.insertion;

public class InsertSort {


    public void insertion(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }
        int t = arr[low];//未排序区域的第一个元素
        int i = low - 1;// 已经排序的区域的第一个元素
        while (i >= 0 && arr[i] > t) {
            arr[i + 1] = arr[i];
            i--;
        }
        if (i + 1 != low) {
            arr[i + 1] = t;
        }
        insertion(arr, low + 1);
    }
}
