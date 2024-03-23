package com.lin.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    private int[] array = {};

        public int[] array() {
        return Arrays.copyOf(array, size);
    }
    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size,element);
    }

    /**
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        checkAndGrow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if (size==0) {
           array = new int[capacity];
        }else if (size==capacity){
            capacity +=capacity>>1;

        int[] newarray = new int[capacity];
        System.arraycopy(array,0,newarray,0,size);
        array=newarray;
        }
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

    /**
     * 遍历方法2
     * 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i =0;

            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }
    /**
     * 遍历方法3 - stream 遍历
     *
     * @return stream 流
     */
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }


    public int remove(int index) {
        int remove = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        return remove;
    }
}
