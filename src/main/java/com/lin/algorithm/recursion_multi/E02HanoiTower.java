package com.lin.algorithm.recursion_multi;

import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * ClassName E02HanoiTower
 * Package com.lin.algorithm.recursion_multi
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/22
 */
public class E02HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n){
        for (int i=n;i>0;i--){
            a.addLast(i);
        }
    }

    /**
     * @param a first
     * @param b middle
     * @param c final
     */
    static void move(int n,LinkedList<Integer> a,
                     LinkedList<Integer> b,LinkedList<Integer> c){
        if (n == 0) {
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);
    }


    public static void main(String[] args) {
//        StopWatch sw = new StopWatch();
        int n = 3;
        init(n);
        print();
//        sw.start("n=1");
        move(n, a, b, c);
//        sw.stop();
//        print();
//        System.out.println(sw.prettyPrint());
    }

    private static void print() {
        System.out.println("----------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
