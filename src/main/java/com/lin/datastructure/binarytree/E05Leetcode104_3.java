package com.lin.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName E05Leetcode104_3
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E05Leetcode104_3 {
    public int depthMax(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "\t");
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }

            }
            depth++;
            System.out.println();
        }

        return depth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(new TreeNode(7), 5, null)
                ),
                1,
                new TreeNode(null, 3, new TreeNode(6)));
        new E05Leetcode104_3().depthMax(root);
    }
}
