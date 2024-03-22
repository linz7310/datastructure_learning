package com.lin.datastructure.priorityqueue;

import com.lin.datastructure.queue.Queue;

/**
 * ClassName PriorityQueue1
 * Package com.lin.datastructure.priorityqueue
 * Description:
 *Based on <b>unordered array</b> implementation
 * @Author: Lin
 * @Creat: 2024/3/20
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    public Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        array[size] = e;
        size++;
        return true;
    }
    private int selectMax(){
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority()>array[max].priority()){
                max=i;
            }
        }
        return max;

    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }
    private void remove(int index) {
        if (index < size - 1) {
            // 移动
            System.arraycopy(array, index + 1,
                    array, index, size - 1 - index);
        }
        array[--size] = null; // help GC
    }
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==array.length;
    }
}
