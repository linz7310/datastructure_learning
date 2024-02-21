package com.lin.algorithm.recursion_multi;

import java.util.Arrays;

/**
 * ClassName E01Fibonacci
 * Package com.lin.algorithm.recursion_multi
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/21
 */
public class E01Fibonacci {
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1); // [-1,-1,-1,-1,-1,-1]
        cache[0] = 0;
        cache[1] = 1; // [0,1,-1,-1,-1,-1]
        return f(n, cache);
    }
    private static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y; // // [0,1,?,-1,-1,-1] 存入数组
        return cache[n];
    }
}
