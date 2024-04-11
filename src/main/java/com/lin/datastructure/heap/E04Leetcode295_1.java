package com.lin.datastructure.heap;

/**
 * ClassName E04Leetcode295_1
 * Package com.lin.datastructure.heap
 * Description:
 * Median of the data stream
 * @Author: Lin
 * @Creat: 2024/3/31
 */


import java.util.PriorityQueue;

/**
 * 为了保证两边数据量的平衡
 * <ul>
 * <li>两边个数一样时,左边个数加一</li>
 * <li>两边个数不一样时,右边个数加一</li>
 * </ul>
 * 但是, 随便一个数能直接加入吗?
 * <ul>
 * <li>左边个数加一时, 把新元素加在右边，弹出右边最小的加入左边</li>
 * <li>右边个数加一时, 把新元素加在左边，弹出左边最小的加入右边</li>
 * </ul>
 */
public class E04Leetcode295_1 {
    private Heap left = new Heap(10, true);
    private Heap right = new Heap(10, false);

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    public static void main(String[] args) {
        E04Leetcode295_1 test = new E04Leetcode295_1();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        test.addNum(7);
        test.addNum(8);
        test.addNum(9);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test.findMedian());
        test.addNum(4);
        System.out.println(test.findMedian());
    }
}
