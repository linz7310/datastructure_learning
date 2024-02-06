package com.lin.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName DynamicArray
 * Package com.lin.datastructure.array
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/6
 */
public class DynamicArray implements Iterable<Integer>{
    private int size = 0;
    private int capacity = 8;
    private int[] array = new int[capacity];

    //    public int[] array() {
//        return Arrays.copyOf(array, size);
//    }
    public void addLast(int element) {
        array[size] = element;
        size++;
    }

    /**
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }


    public int get(int index) {
        return array[index];
    }

    /**
     * 遍历方法1
     *
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     */
    public void forEach1(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // provide array[i]
            // return void
            consumer.accept(array[i]);
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        }
    }
}
