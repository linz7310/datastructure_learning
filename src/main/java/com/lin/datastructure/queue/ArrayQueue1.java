package com.lin.datastructure.queue;

import java.util.Iterator;

/**
 * ClassName ArrayQueue1
 * Package com.lin.datastructure.queue
 * Description:
 * Only use head, tail to determine if it's full,
 * head, tail is the index value,
 * tail stops at a location that doesn't store an element.
 *
 * @Author: Lin
 * @Creat: 2024/3/5
 */
public  class ArrayQueue1<E> implements Queue<E>, Iterable<E>{

    private final E[] array;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue1(int capacity) {
        this.array = (E[]) new Object[capacity+1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail]=value;
        tail=(tail+1)%array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value =array[head];
        head=(head+1)%array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return tail==head;
    }

    @Override
    public boolean isFull() {
        return (tail+1)%array.length==head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }

}
