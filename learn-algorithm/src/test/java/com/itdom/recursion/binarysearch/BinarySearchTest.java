package com.itdom.recursion.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    public void bf() {

        BinarySearch bs = new BinarySearch();
        int[] arr = {1,3,4,8,9,15,21,57};
        assertEquals(4,bs.bf(arr,9,0,arr.length-1));
    }
}