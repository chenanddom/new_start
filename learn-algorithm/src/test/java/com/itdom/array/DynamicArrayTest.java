package com.itdom.array;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {

    @Test
    public void test1() {
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);

        int delete = array.delete(2);
        assertEquals(3, delete);
        assertIterableEquals(Arrays.asList(1, 2, 4, 5), array);

    }
}
