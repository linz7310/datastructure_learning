package com.lin.datastructure.deque;
import com.lin.datastructure.queue.LinkedListQueue;
import com.lin.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName E01Leetcode103
 * Package com.lin.datastructure.deque
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/3/19
 */
public class E01Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListQueue<Object> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;
        boolean odd = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = (TreeNode) queue.poll();
                if (odd) {
                    level.offerLast(n.val);
                } else {
                    level.offerFirst(n.val);
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            odd = !odd;
            result.add(level);
            c1 = c2;
        }
        return result;
    }



        /*
                  1
                 / \
                2   3
               /\   /\
              4  5 6  7
             /\
            8  9

              1
              3 2
              4 5 6 7
              9 8
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        List<List<Integer>> lists = new E01Leetcode103().zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}