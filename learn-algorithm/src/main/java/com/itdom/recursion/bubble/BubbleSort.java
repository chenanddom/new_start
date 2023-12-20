package com.itdom.recursion.bubble;

/**
 * 使用递归实现冒泡排序
 */
public class BubbleSort {

    public void sort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }
    public void sortPlus(int[] arr) {
        bubbleSortPlus(arr, arr.length - 1);
    }

    /**
     * 普通排版的递归
     *
     * @param arr
     * @param j
     */
    private void bubbleSort(int[] arr, int j) {
        if (j == 0) {//标识有便捷到达最小，已经完成了排序
            return;
        }
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        bubbleSort(arr, j - 1);
    }

    /**
     * 使用b变量记录右边拍好序的数组的边界脚标
     * @param arr
     * @param j
     */
    public void bubbleSortPlus(int[] arr, int j) {
        if (j == 0) {
            return;
        }
        int b = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                b = i;
            }
        }
        bubbleSortPlus(arr, b);
    }
}
