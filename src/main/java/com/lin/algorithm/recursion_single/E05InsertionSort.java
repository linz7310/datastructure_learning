package com.lin.algorithm.recursion_single;

/**
 * ClassName E05InsertionSort
 * Package com.lin.algorithm.recursion_single
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/21
 */
public class E05InsertionSort {
    public static void sort(int[] a){
        insertion(a,1);
    }

    private static void insertion(int[] a,int low){
        if (low==a.length){
            return;
        }
            int t = a[low];
            int i = low-1;
            while (i>=0&&t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            a[i+1] = t;
            insertion(a,low+1);
    }
}
