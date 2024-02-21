package com.lin.algorithm.recursion_single;

/**
 * ClassName E04BubbleSort
 * Package com.lin.algorithm.recursion_single
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/21
 */
public class E04BubbleSort {
    public static void sort(int[] a){
        bubble(a,a.length-1);
    }
    public static void bubble(int[] a, int j){
        if (j==0){
            return;
        }
        int t = 0;
       for (int i=0;i<j;i++){
           if (a[i]>a[i+1]) {
               int m = a[i];
               a[i] = a[i + 1];
               a[i + 1] = m;
               t=a[i];
           }
       }
       bubble(a,t);
    }
}
