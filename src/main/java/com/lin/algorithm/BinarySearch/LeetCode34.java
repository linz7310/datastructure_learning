package com.lin.algorithm.BinarySearch;

/**
 * ClassName LeetCode34
 * Package com.lin.algorithm.BinarySearch
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/4
 */
public class LeetCode34 {
    public int[] searchRange(int[] a, int target) {
        int x = left(a, target);
        if (x == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{x, right(a, target)};
        }
    }

    public int left(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    public int right(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }
}
