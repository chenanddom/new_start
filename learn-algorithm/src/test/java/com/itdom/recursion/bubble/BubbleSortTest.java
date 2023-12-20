package com.itdom.recursion.bubble;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {3,1,7,4,0,5};// 1 3 7 4 0 5 -  1 3 7 4 0 5 - 1 3 4 7 0 5 - 1 3 4 0 7 5 - 1 3 4 0 5 7
        // 1 3 4 0 5 7 - 1 3 4 0 5 7 - 1 3 0 4 5 7
        bubbleSort.sort(arr);
        int[] expectArray = {0,1,3,4,5,7};
        assertArrayEquals(expectArray,arr);


    }

    /**
     * 增强版本冒泡排序
     */
    @Test
    void sortPlus() {

        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {3,1,7,4,0,5};
        bubbleSort.sortPlus(arr);
        int[] expectArray = {0,1,3,4,5,7};
        assertArrayEquals(expectArray,arr);
    }
}