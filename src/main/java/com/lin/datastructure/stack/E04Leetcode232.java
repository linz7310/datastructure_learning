package com.lin.datastructure.stack;

/**
 * ClassName E04Leetcode232
 * Package com.lin.datastructure.stack
 * Description: double stack analogue queue
 *
 * @Author: Lin
 * @Creat: 2024/3/12
 */
public class E04Leetcode232 {
    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);
    public void push(int x){
        s2.push(x);
    }
    public Integer pop(){
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }
    public int peek() { // 从对列头获取
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

