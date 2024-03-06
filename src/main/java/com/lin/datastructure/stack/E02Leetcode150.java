package com.lin.datastructure.stack;

import java.util.LinkedList;

/**
 * ClassName E02Leetcode150
 * Package com.lin.datastructure.stack
 * Description:Suffix expression evaluation
 *
 * @Author: Lin
 * @Creat: 2024/3/6
 */
public class E02Leetcode150 {
    public int evalRPN(String[] tokens){
        LinkedList<Integer> stack =new LinkedList<>();
        for (String t:tokens){
            switch (t){
                case "+" ->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a+b);
                }
                case "-" ->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b-a);
                }
                case "*" ->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a*b);
                }
                case "/" ->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b/a);
                }
                default -> {
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }
}
