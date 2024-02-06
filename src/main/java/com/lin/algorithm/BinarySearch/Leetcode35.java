package com.lin.algorithm.BinarySearch;

/**
 * ClassName Leetcode35
 * Package com.lin.algorithm.BinarySearch
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/3
 */
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid= (l+r) >>>1;
            long midVal = nums[mid];
            if (target<midVal){
                r=mid-1;
            }else if(midVal<target){
                l=mid+1;
            } else {
                return mid;
            }
        }
            return l;
    }
}
