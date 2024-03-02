package com.lin.datastructure.linkedlist;

/**
 * ClassName E04Leetcode83
 * Package com.lin.datastructure.linkedlist
 * Description:Ordered chained table de-duplication
 *
 * @Author: Lin
 * @Creat: 2024/2/27
 */
public class E04Leetcode83 {
    public ListNode deleteDuplicates1(ListNode head){
        if (head==null|| head.next==null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2!=null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
                p1.next = p2;
            } else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val==head.next.val) {
            head = deleteDuplicates2(head.next);
            return head;
        }else {
            head.next=deleteDuplicates2(head.next);
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3);
        System.out.println(head);
        System.out.println(new E04Leetcode83().deleteDuplicates1(head));
    }
}
