package com.lin.algorithm.recursion_single;

/**
 * ClassName E03BinarySearch
 * Package com.lin.algorithm.recursion_single
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/21
 */
public class E03BinarySearch {
    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }
    private static int f(int[] a,int target, int i, int j ){
        int m =(i+j) >>>1;
        if (i>j){
            return -1;
        }
        if (target<a[m]) {
            return f(a,target,i,m-1);
        } else if (a[m]<target){
            return f(a,target,m+1,j);
        }else {
            return m;
        }
    }
}
