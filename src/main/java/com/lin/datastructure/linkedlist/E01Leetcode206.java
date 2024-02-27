package com.lin.datastructure.linkedlist;


/**
 * ClassName E01Leetcode206
 * Package com.lin.datastructure.linkedlist
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/26
 */
public class E01Leetcode206 {
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
           n1 = new ListNode(p.val,n1);
                    p=p.next;
        }
        return n1;
    }

    public ListNode reverseList2(ListNode head){
     list list1 = new list(head);
     list list2 = new list(null);
     while (true){
         ListNode first =list1.removeFirst();
         if (first==null){
             break;
         }
         list2.addFirst(first);
     }
     return list2.head;


    }
    static class list{
        ListNode head;

        public list(ListNode head) {
            this.head = head;
        }
        public void addFirst(ListNode first){
            first.next=head;
            head=first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first!=null){
                head=first.next;
            }
            return first;
        }

    }

    public ListNode reverseList3(ListNode p){
        if (p==null||p.next==null){
            return p;
        }
        ListNode last = reverseList3(p.next);
        p.next.next=p;
        p.next=null;
        return last;
    }
    public ListNode reverseList4(ListNode head){
        ListNode o2 = head.next;
        ListNode n1 = head;
        while (o2!=null) {
            head.next = o2.next;
            o2.next = n1;
            n1=o2;
            o2=head.next;
        }
        return n1;

    }
    public ListNode reverseList5(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n1= null;
        while (head!=null){
            ListNode o2 = head.next;
            head.next=n1;
            n1=head;
            head=o2;
        }
        return n1;
    }





    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new E01Leetcode206().reverseList4(o1);
        System.out.println(n1);
    }

}
