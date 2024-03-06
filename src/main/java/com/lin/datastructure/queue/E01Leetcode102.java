package com.lin.datastructure.queue;

import com.lin.datastructure.binarytree.TreeNode;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName E01Leetcode102
 * Package com.lin.datastructure.queue
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/3/6
 */
public class E01Leetcode102 {


    public List<List<Integer>> levelOrder1(TreeNode root) {
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        int c1 = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }

            }
            result.add(level);
            c1 = c2;

        }
        return result;
    }

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
        List<List<Integer>> lists = new E01Leetcode102().levelOrder1(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}