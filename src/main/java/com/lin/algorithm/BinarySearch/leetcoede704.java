package com.lin.algorithm.BinarySearch;

/**
 * ClassName binarysearch
 * Package com.lin.algorithm
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/1
 */
public class leetcoede704 {
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target > a[mid]) {
                i = mid + 1;
            } else if (target < a[mid]) {
                j = mid - 1;
            }
        }
        return -1;
    }

}


