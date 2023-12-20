package com.itdom.doublylinckedlistsentinel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinckedListSentinelTest {
    @Test
    public void addFirstTest() {
        DoublyLinckedListSentinel sentinel = new DoublyLinckedListSentinel();
        sentinel.addFirst(1);
        sentinel.addFirst(2);
        sentinel.addFirst(3);
        sentinel.addFirst(4);
        sentinel.addFirst(5);
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        assertIterableEquals(list, sentinel);

    }

    @Test
    void addLast() {
    }

    @Test
    void removeFirst() {
        DoublyLinckedListSentinel sentinel = new DoublyLinckedListSentinel();
        sentinel.addFirst(1);
        sentinel.addFirst(2);
        List<Integer> list = Arrays.asList(2, 1);
        assertIterableEquals(list, sentinel);
        sentinel.removeFirst();
        list = Arrays.asList(1);
        assertIterableEquals(list, sentinel);
        sentinel.removeFirst();
        assertThrows(IllegalArgumentException.class, sentinel::removeFirst);
    }

    @Test
    void removeLast() {
        DoublyLinckedListSentinel sentinel = new DoublyLinckedListSentinel();
        sentinel.addFirst(1);
        sentinel.addFirst(2);
        sentinel.addFirst(3);
        sentinel.removeFirst();
        List<Integer> list = Arrays.asList(2, 1);
        assertIterableEquals(list, sentinel);


    }

    @Test
    void removedByValue() {
        DoublyLinckedListSentinel sentinel = new DoublyLinckedListSentinel();
        sentinel.addFirst(1);
        sentinel.addFirst(2);
        sentinel.addFirst(3);
        sentinel.removedByValue(2);
        sentinel.removedByValue(3);

        List<Integer> list = Arrays.asList(1);
        assertIterableEquals(list, sentinel);


    }
}