package com.itdom.recursion.factorial;

/**
 * 阶乘使用递归的算法
 */
public class Factorial {


    public int fun(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fun(n - 1);
    }

}
