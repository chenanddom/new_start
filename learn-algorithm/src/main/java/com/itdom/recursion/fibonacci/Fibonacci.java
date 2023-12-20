package com.itdom.recursion.fibonacci;

import java.util.Arrays;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int r1 = fibonacci(n - 1);
        int r2 = fibonacci(n - 2);
        return r1 + r2;
    }

    public static int fibonacciPro(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return fibonacciPlus(n, cache);
    }

    public static int fibonacciPlus(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        int r1 = fibonacciPlus(n - 1, cache);
        int r2 = fibonacciPlus(n - 2, cache);
        cache[n] = r1 + r2;
        return cache[n];
    }
}
