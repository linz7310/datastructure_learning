package com.lin.datastructure.linkedlist;

import java.util.Iterator;

/**
 * ClassName DoublyLinkedListSentinel
 * Package com.lin.datastructure.linkedlist
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/20
 */
public class DoublyLinkedListSentinel implements Iterable{
    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
        private Node head;
        private Node tail;
        public DoublyLinkedListSentinel(){
            head = new Node(null,666,null);
            tail = new Node(null,888,null);
            head.next=tail;
            tail.prev=head;
        }
        public Node findNode(int index){
            int i = -1;
            for (Node p = head;p!=tail;p=p.next,i++){
                if (i == index){
                    return p;
                }
            }
            return null;
        }
         public void addFirst(int value) {
                insert(value, 0);
        }
        public void addLast(int value){
            Node prev = tail.prev;
            Node last = new Node(prev,value,tail);
            prev.next=last;
            tail.prev=last;
        }
        public void insert(int value,int index){
            Node prev = findNode(index - 1);
            if (prev == null) {
                throw illegalIndex(index);
            }
            Node next = prev.next;
            Node inserted=new Node(prev,value,next);
            next.prev=inserted;
            prev.next=inserted;
        }
    public void removeFirst() {
        remove(0);
    }
    public void removeLast(){
            Node last = tail.prev;
            Node prev = last.prev;
            prev.next=tail;
            tail.prev=prev;

    }
        public void remove(int index){
            Node prev = findNode(index - 1);
            if (prev == null) {
                throw illegalIndex(index);
            }
            Node removed = prev.next;
            if (removed==tail){
                throw illegalIndex(index);
            }
            Node next = removed.next;
            prev.next=next;
            next.prev=prev;
        }
    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }
}
