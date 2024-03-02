package com.lin.datastructure.linkedlist;

/**
 * ClassName E02Leetcode203
 * Package com.lin.datastructure.linkedlist
 * Description:Delete nodes based on value
 *
 * @Author: Lin
 * @Creat: 2024/2/27
 */
public class E02Leetcode203 {
    public ListNode removeElements(ListNode head,int val){
        ListNode s = new ListNode(666,head);
        ListNode p1 = s;
        ListNode p2 =s.next;
        while (p2!=null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return s.next;
    }
    //recursion
    public ListNode removeElements2(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            return removeElements(p.next, val);
        } else {
            p.next = removeElements(p.next, val);
            return p;
        }
    }



    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new E02Leetcode203()
                .removeElements(head, 6));
    }
}
