package com.itdom.binarysearch;

public class BinarySearch {

    /**
     * 二分查找法
     *
     * @param arr    升序的有序数组
     * @param target 查找的目标值
     * @return 返回目标值的索引或者-1
     */
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1;//设置指针并赋值
        while (i <= j) { //这个范围有东西 (在特殊的情况下这个条件判断可能导致死循环)
//            int m = (i + j) / 2;//中间值的索引(这个地方如果用到了正整数的最大值会出现复数，而使用右移可以规避掉这个问题，而且还可以提升计算的效率)
            int m = (i + j) >>> 1;//中间值的索引
            //如果时在中间的右边就可以少经过一次判断语句，在左边就需要多经过一次判断，所以，这个算法部署平衡的算法
            if (target < arr[m]) {//目标值的值范围在左边
                j = m - 1;
            } else if (arr[m] < target) {//目标值的值范围在右边
                i = m + 1;
            } else {
                return m;
            }

        }
        return -1;
    }

    /**
     * 二分查找法优化
     *
     * @return 返回目标值的索引或者-1
     */
    public static int binarySearchOptimize(int[] arr, int target) {
        int i = 0, j = arr.length;
        //j-i标识i~j之间的元素
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target == arr[i]) {
            return i;
        }
        return -1;
    }

    /**
     * 有重复元素的时候查找最左侧的元素
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchBasicLeftMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;//设置指针并赋值
        int candidate = -1;
        while (i <= j) { //这个范围有东西 (在特殊的情况下这个条件判断可能导致死循环)
//            int m = (i + j) / 2;//中间值的索引(这个地方如果用到了正整数的最大值会出现复数，而使用右移可以规避掉这个问题，而且还可以提升计算的效率)
            int m = (i + j) >>> 1;//中间值的索引
            //如果时在中间的右边就可以少经过一次判断语句，在左边就需要多经过一次判断，所以，这个算法部署平衡的算法
            if (target < arr[m]) {//目标值的值范围在左边
                j = m - 1;
            } else if (arr[m] < target) {//目标值的值范围在右边
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }

        }
        return candidate;
    }
    /**
     * 有重复元素的时候查找最左侧的元素
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchBasicRightMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;//设置指针并赋值
        int candidate = -1;
        while (i <= j) { //这个范围有东西 (在特殊的情况下这个条件判断可能导致死循环)
//            int m = (i + j) / 2;//中间值的索引(这个地方如果用到了正整数的最大值会出现复数，而使用右移可以规避掉这个问题，而且还可以提升计算的效率)
            int m = (i + j) >>> 1;//中间值的索引
            //如果时在中间的右边就可以少经过一次判断语句，在左边就需要多经过一次判断，所以，这个算法部署平衡的算法
            if (target < arr[m]) {//目标值的值范围在左边
                j = m - 1;
            } else if (arr[m] < target) {//目标值的值范围在右边
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }

        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        System.out.println(binarySearchBasic(arr, 21));
        System.out.println(binarySearchOptimize(arr, 21));

        int[] arr2 = {7, 13, 21, 21, 30, 30, 38, 44, 52, 53};
        System.out.println(binarySearchBasicLeftMost(arr2, 30));
        System.out.println(binarySearchBasicRightMost(arr2, 30));


    }
}
