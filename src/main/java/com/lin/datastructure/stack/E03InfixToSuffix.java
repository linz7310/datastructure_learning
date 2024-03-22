package com.lin.datastructure.stack;

import com.google.common.base.CaseFormat;

import java.util.LinkedList;

/**
 * ClassName E03InfixToSuffix
 * Package com.lin.datastructure.stack
 * Description: infix to Suffix
 *
 * @Author: Lin
 * @Creat: 2024/3/12
 */
public class E03InfixToSuffix {
    public static void test() {
        int a = 10;
        int b = 20;
        int c = 5;
        int d = (a + b) * c;
    }
    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }

    static int prority(char c){
        return switch (c){
            case '*','/' ->2;
            case '+','-' ->1;
            case '(' ,')' ->0;
            default ->  throw new IllegalArgumentException("illegal operators :" + c);
        };
    }
    static String infixToSuffix(String exp){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c){
                case '*','/','+','-'-> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (prority(c) > prority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && prority(c) <= prority(stack.peek())) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }

                }
                case'(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }

        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
