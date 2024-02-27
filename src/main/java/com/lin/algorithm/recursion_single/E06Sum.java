package com.lin.algorithm.recursion_single;

/**
 * ClassName E06Sum
 * Package com.lin.algorithm.recursion_single
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/22
 */
public class E06Sum {
    public static long sum(long n){
        if (n==1){
            return 1;
        }

        return n+sum(n-1);
    }

public static void main(String[] args) {
    System.out.println(E06Sum.sum(100));
}

}
