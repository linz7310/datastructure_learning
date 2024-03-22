package com.lin.datastructure.priorityqueue;

import com.lin.datastructure.queue.Queue;

/**
 * ClassName PriorityQueue4
 * Package com.lin.datastructure.priorityqueue
 * Description:
 * Based on <b>Big Top Stack</b> implementation
 * @Author: Lin
 * @Creat: 2024/3/20
 */
public class PriorityQueue4<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue4(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child-1)/2;
        while (child>0&&offered.priority()>array[parent].priority()){
            array[child]=array[parent];
            child=parent;
            parent=(child-1)/2;
        }
        array[child]=offered;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0,size-1);
        size--;
        Priority e = array[size];
        array[size] = null;
        down(0);
        return (E) e;
    }
    private void down(int parent){
        int left = parent*2 +1;
        int right = parent*2+2;
        int max = parent;
        if (left < size &&array[left].priority()>array[max].priority()){
            max=left;
        }
        if (right < size &&array[right].priority()>array[max].priority()){
            max=right;
        }
        if (max!=parent){
            swap(max,parent);
            down(max);
        }

    }
    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
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
