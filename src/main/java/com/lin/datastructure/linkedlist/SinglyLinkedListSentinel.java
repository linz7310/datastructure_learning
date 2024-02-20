package com.lin.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName SinglyLinkedListSentinel
 * Package com.lin.datastructure.linkedlist
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/19
 */
public class SinglyLinkedListSentinel implements Iterable{
    private Node head = new Node(666,null);

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
           Node p = head.next;
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
        public Node (int value, Node next){
            this.value =value;
            this.next= next;
        }
    }
    public void addFirst(int value){
        insert(0, value);
    }
    public void loop1(Consumer<Integer> consumer){
        Node p =head.next;
        while (p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for (Node p = head.next; p!=null; p=p.next){
            consumer.accept(p.value);
        }
    }
    private Node findLast(){

        Node p;
        for (p=head;p.next!=null;p=p.next){}
        return p;
    }
    public void addLast(int value){
        Node last = findLast();

        last.next = new Node(value,null);
    }
    private Node findNode(int index){
        int i =-1;
        for (Node p = head; p!=null; p=p.next,i++) {
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
    public void insert(int index,int value) throws IllegalArgumentException{
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
