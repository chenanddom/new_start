package com.itdom.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void fun() {
        int n=5;
        Factorial factorial = new Factorial();
        int result = factorial.fun(n);
        assertEquals(120,result);


    }
}