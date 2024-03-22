package com.lin.datastructure.priorityqueue;

import com.lin.datastructure.queue.Queue;

/**
 * ClassName PriorityQueue2
 * Package com.lin.datastructure.priorityqueue
 * Description:
 *  Based on <b>ordered array</b> implementation
 * @Author: Lin
 * @Creat: 2024/3/20
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }
    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        insert(e);
        size++;
        return true;
    }
    private void insert(E e){
        int i = size-1;
        while (i>=0&&array[i].priority()>e.priority()){
            array[i+1]=array[i];
            i--;
        }
    }
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[size - 1];
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}

