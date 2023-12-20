package com.itdom.recursion.insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void insertion() {

        InsertSort insertSort = new InsertSort();
        int[] arr = {6,2,1,5,4};
        insertSort.insertion(arr,1);
        int[] expectedArray = {1,2,4,5,6};
        assertArrayEquals(expectedArray,arr);
    }
}