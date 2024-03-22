package com.lin.datastructure.priorityqueue;

import com.google.common.collect.Lists;
import com.lin.datastructure.linkedlist.ListNode;

/**
 * ClassName E01Leetcode23
 * Package com.lin.datastructure.priorityqueue
 * Description:
 * Merging multiple ordered lists
 * @Author: Lin
 * @Creat: 2024/3/22
 */
public class E01Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        for (ListNode h :lists) {
            if (h!=null){
                heap.offer(h);
            }
        }
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (!heap.isEmpty()){
            ListNode min= heap.poll();
            p.next = min;
            p= min;
            if (min.next!=null){
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null,
        };
        ListNode m = new E01Leetcode23().mergeKLists(lists);
        System.out.println(m);
    }
}
