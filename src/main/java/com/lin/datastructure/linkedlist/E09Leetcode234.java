package com.lin.datastructure.linkedlist;

/**
 * ClassName E09Leetcode234
 * Package com.lin.datastructure.linkedlist
 * Description: if palindrome
 *
 * @Author: Lin
 * @Creat: 2024/2/28
 */
public class E09Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middle(head);
        System.out.println(middle);
        ListNode newHead = reverse1(middle);
        System.out.println(newHead);
        while (newHead !=null){
            if (newHead.val!=head.val) {
                return false;
            }
            newHead=newHead.next;
            head=head.next;
        }
        return true;
    }
        private ListNode reverse1(ListNode o1){
        ListNode p =o1;
        ListNode n1=null;
        while (p!=null){
            n1 =new ListNode(p.val,n1);
            p=p.next;
        }
        return n1;
    }
    public ListNode reverse2(ListNode o1){
        ListNode n1 = null;
        while (o1!=null){
            ListNode o2 = o1.next;
            o1.next=n1;
            n1=o1;
            o1=o2;
        }
        return n1;
    }
    private ListNode middle(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1;
    }


    public boolean isPalindrome1(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        ListNode n1 = null; // 新头
        ListNode o1 = head; // 旧头
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        System.out.println(n1);
        System.out.println(p1);

        if (p2 != null) { // 奇数节点
            p1 = p1.next;
        }

        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new E09Leetcode234()
                .isPalindrome(ListNode.of(1, 2, 2, 1)));
        System.out.println(new E09Leetcode234()
                .isPalindrome(ListNode.of(1, 2, 3, 2, 1)));
    }
}
