package com.lin.datastructure.linkedlist;

/**
 * ClassName E06Leetcode21
 * Package com.lin.datastructure.linkedlist
 * Description:Merging two ordered linked lists
 *
 * @Author: Lin
 * @Creat: 2024/2/28
 */
public class E06Leetcode21 {
    public ListNode mergeTwoLists(ListNode p1,ListNode p2){
        ListNode s = new ListNode(-1, null);
        ListNode p =s;
        while (p1!=null&& p2!=null){
            if (p1.val>=p2.val){
                p.next=p2;
                p2=p2.next;
                p=p.next;

            }else if (p2.val> p1.val){
                p.next=p1;
                p1=p1.next;
                p=p.next;
            }
        }
        if (p1!=null){
            p.next=p1;
        }
        if (p2!=null){
            p.next=p2;
        }
        return s.next;
    }
    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        if (p2==null){
            return p1;
        }
        if (p1==null){
            return p2;
        }
        if (p1.val<p2.val){
            p1.next=mergeTwoLists2(p1.next,p2);
            return p1;
        }else {
            p2.next=mergeTwoLists2(p1,p2.next);
            return p2;
        }

    }




    public static void main(String[] args) {
//        ListNode p1 = ListNode.of(1, 3, 8, 9, 10);
//        ListNode p2 = ListNode.of(2, 4);

        ListNode p1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(8,
                                new ListNode(9,
                                        new ListNode(10, null)
                                )
                        )
                )
        );
        ListNode p2 = new ListNode(2, new ListNode(4, null));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(new E06Leetcode21()
                .mergeTwoLists2(p1, p2));
    }
}
