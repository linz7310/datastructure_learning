package com.lin.datastructure.queue;

import java.util.Iterator;

/**
 * ClassName ArrayQueue3
 * Package com.lin.datastructure.queue
 * Description:
 * Only use head, tail to judge empty, head, tail need to be converted to index value
 * @Author: Lin
 * @Creat: 2024/3/5
 */


    /*
        求模运算：
        - 如果除数是 2 的 n 次方
        - 那么被除数的后 n 位即为余数 (模)
        - 求被除数的后 n 位方法： 与 2^n-1 按位与
     */
public class ArrayQueue3<E> implements Queue<E>,Iterable<E> {
    private final E[] array;
    public int head = 0;
    public int tail = 0;
    public ArrayQueue3(int capacity){
        array= (E[]) new Object[capacity];
    }
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
//        array[tail]= value;
        array[tail & (array.length - 1)] = value;
        tail++;

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int idx = head & (array.length - 1);
        E value = array[idx];
        array[idx] = null; // help GC
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return array[head & (array.length - 1)];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
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
                E value = array[p & (array.length - 1)];
                p++;
                return value;
            }
        };
    }
}
