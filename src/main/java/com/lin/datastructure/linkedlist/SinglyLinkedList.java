package com.lin.datastructure.linkedlist;

import org.w3c.dom.Node;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName SinglyLinkedList
 * Package com.lin.datastructure.linkedlist
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/18
 */
public class SinglyLinkedList implements Iterable<Integer>{
   private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            SinglyLinkedList.Node p = head;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p=p.next;
                return v;
            }
        };
    }

    private static class Node{
        int value;
        Node next;
        public Node (int value,Node next){
            this.value =value;
            this.next= next;
        }
    }
    public void addFirst(int value){
       head = new Node(value,head);
    }
public void loop1(Consumer<Integer> consumer){
       Node p =head;
       while (p!=null){
           consumer.accept(p.value);
           p=p.next;
       }
}
public void loop2(Consumer<Integer> consumer){
       for (Node p =head;p!=null;p=p.next){
           consumer.accept(p.value);
       }

}
        public void loop3(){
            recursion(head);
        }
        private void recursion(Node curr){
            if (curr==null){
                return;
            }
            System.out.println(curr.value);
            recursion(curr.next);
        }
private Node findLast(){
        if (head==null){
            return null;
        }
        Node p;
        for (p=head;p.next!=null;p=p.next){}
    return p;
    }
    public void addLast(int value){
        Node last = findLast();
        if (last==null){
            addFirst(value);
            return;
        }
        last.next = new Node(value,null);
    }
    private Node findNode(int index){
        int i =0;
       for (Node p =head;p!=null;p=p.next,i++) {
           if (i == index) {
               return p;
           }
       }
       return null;
    }

    public int get(int index){
        Node node= findNode(index);
        if (node==null){
            illegal(index);
        }
        return node.value;
    }
    public void insert(int index,int value){
        if (index==0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index -1);
        if (prev == null){
          throw  illegal(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private IllegalArgumentException illegal(int index) {
        throw new IllegalArgumentException(
                String.format("index [%d] illegal%n", index));
    }

    public void remove(int index){
        if (index == 0){
            head = head.next;
            return;
        }
        Node prev =  findNode(index-1);
        if (prev == null) {
           throw  illegal(index);
        }
        Node remove = prev.next;
        if (remove==null){
            throw illegal(index);
        }
        prev.next = remove.next;
    }
}
