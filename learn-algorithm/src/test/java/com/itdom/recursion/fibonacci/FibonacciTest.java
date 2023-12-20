package com.itdom.recursion.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacci() {
        int fibonacci = Fibonacci.fibonacci(5);
        assertEquals(5,fibonacci);

    }

    @Test
    void fibonacciPro() {
        int fibonacci = Fibonacci.fibonacci(5);
        assertEquals(5,fibonacci);
    }
}