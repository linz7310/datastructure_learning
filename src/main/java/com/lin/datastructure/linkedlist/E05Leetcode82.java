package com.lin.datastructure.linkedlist;

/**
 * ClassName E05Leetcode82
 * Package com.lin.datastructure.linkedlist
 * Description:Ordered chained table de-duplication
 *
 * @Author: Lin
 * @Creat: 2024/2/27
 */
public class E05Leetcode82 {
    public ListNode deleteDuplicates(ListNode p){
        if (p==null||p.next==null){
            return  p;
        }
        if (p.val==p.next.val){
            ListNode x=p.next.next;
            while (x!=null && x.val==p.val){
                x=x.next;
            }
            return deleteDuplicates(x);
        }else {
            p.next =deleteDuplicates(p.next);
            return p;
        }

    }

    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode s = new ListNode(-1, p);
        ListNode p1 = s;
        ListNode p2 = p;
        ListNode p3 = p.next;
        while (p3 != null) {
            if (p2.val == p3.val) {
                while (p3!=null &&p3.val == p2.val) {
                    p3 = p3.next;
                }
                p1.next = p3;
                p2=p1.next;
                if (p3!=null) {
                    p3 = p2.next;
                }
            }else {
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
        }
        }
        return s;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2=p1.next)!=null&&(p3=p2.next)!=null){
            if (p2.val==p3.val){
                while ((p3=p3.next)!=null &&p3.val==p2.val){

                }
                p1.next=p3;
            }else {
                p1=p1.next;
            }
        }
        return s.next;
    }


        public static void main(String[] args) {
//            ListNode head = ListNode.of(1, 2, 3, 3, 4, 4, 5);
        ListNode head = ListNode.of(1, 1, 1);
            System.out.println(head);
            System.out.println(new E05Leetcode82().deleteDuplicates2(head));
        }

    }
