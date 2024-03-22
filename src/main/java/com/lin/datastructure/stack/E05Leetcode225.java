package com.lin.datastructure.stack;

import com.lin.datastructure.queue.ArrayQueue3;

/**
 * ClassName E05Leetcode225
 * Package com.lin.datastructure.stack
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/3/12
 */
public class E05Leetcode225 {
    ArrayQueue3<Integer> queue = new ArrayQueue3<>(100);
    private int size = 0;

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
