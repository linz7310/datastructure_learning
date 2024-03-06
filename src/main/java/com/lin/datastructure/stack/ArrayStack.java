package com.lin.datastructure.stack;

import java.util.Iterator;

/**
 * ClassName ArrayStack
 * Package com.lin.datastructure.stack
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/3/6
 */
public class ArrayStack<E> implements Stack<E> , Iterable<E>{
    private final E[] array;
    private int top;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];

    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top]=value;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        E e = array[top-1];
        top--;
        return e;
    }

    @Override
    public E peek() {        if (isEmpty()){
        return null;
    }


        return array[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public boolean isFull() {
        return top==array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p =top;
            @Override
            public boolean hasNext() {
                return p>0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
