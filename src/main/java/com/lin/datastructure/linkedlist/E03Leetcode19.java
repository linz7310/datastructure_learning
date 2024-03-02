package com.lin.datastructure.linkedlist;

/**
 * ClassName E03Leetcode19
 * Package com.lin.datastructure.linkedlist
 * Description:Delete Countdown Node
 *
 * @Author: Lin
 * @Creat: 2024/2/27
 */
public class E03Leetcode19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }
    public int recursion(ListNode p,int n){
        if (p==null){
            return 0;
        }
        int nth=recursion(p.next,n);
        if (nth==n){
            p.next=p.next.next;
        }
        return nth+1;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1,head);
        ListNode p1 =s;
        ListNode p2 =s;
        for (int i = 0; i < n+1; i++) {
            p2=p2.next;
        }
        while (p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return s.next;

    }


        public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
//        ListNode head = ListNode.of(1,2);
        System.out.println(head);
        System.out.println(new E03Leetcode19()
                .removeNthFromEnd2(head, 5));
    }
}
