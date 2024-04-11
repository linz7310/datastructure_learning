package com.lin.datastructure.heap;

import java.util.Arrays;

/**
 * ClassName MaxHeap
 * Package com.lin.datastructure.heap
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/3/25
 */
public class MaxHeap {
    int[] array;
    int size;
    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }
    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }
    public int peak() {
        return array[0];
    }
    public int poll(){
        int top = array[0];
        swap(0,size-1);
        down(0);
        return top;
    }

    /**
     * @param index
     * @return deleted number
     */
    public int poll(int index){
        int deleted = array[index];
        swap(deleted,size-1);
        size--;
        down(index);
        return deleted;
    }
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }
    private void up(int offered, int index){
        int child = index;
        while (child>0){
            int parent = (child-1)/2;
            if (offered > array[parent]){
                array[child] = array[parent];
            }else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }
    private void heapify(){
        for (int i = size/2 - 1; i >=0 ; i--) {
            down(i);
        }
    }
    // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
    public void down(int parent){
        int left = parent * 2 +1;
        int right = left +1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        if (max != parent){
            swap(max,parent);
            down(max);
        }
    }

    private void swap(int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void main(String[] args) {

        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MaxHeap heap = new MaxHeap(array);
        System.out.println(Arrays.toString(heap.array));

        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }

        System.out.println(Arrays.toString(heap.array));
    }
}
