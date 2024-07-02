package com.lin.datastructure.LinkedList;

import com.lin.datastructure.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName TestSinglyLinkedList
 * Package lin.datastructure.LinkedList
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/2/18
 */
public class TestSinglyLinkedList {
    @Test
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(value -> {
            System.out.println(value);
        });

    }

    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
//        Assertions.assertIterableEquals(List.of(1,2,3,4),list);
        int i = list.get(2);
        System.out.println(i);
    }


    @Test
    @DisplayName("test insert")
    public void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.insert(2, 10);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("test remove")
    public void test5() {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.remove(2);
        for (Integer value : list1) {
            System.out.println(value);
        }


//        SinglyLinkedList list2 = new SinglyLinkedList();
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(4);
//        list2.remove(4);
//
//        for (Integer value : list2) {
//            System.out.println(value);
//        }
    }
}