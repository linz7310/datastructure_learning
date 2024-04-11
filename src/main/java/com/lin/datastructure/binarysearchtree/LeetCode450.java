package com.lin.datastructure.binarysearchtree;

import java.time.OffsetDateTime;

/**
 * ClassName LeetCode450
 * Package com.lin.datastructure.binarysearchtree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/11
 */
public class LeetCode450 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode root;
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null; // 如果根节点为空，直接返回null
        }
        TreeNode parent = null;
        TreeNode p = root;
        // 查找要删除的节点
        while (p != null && p.val != val) {
            parent = p;
            if (val < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            return root; // 没找到要删除的节点
        }
        if (p.left == null || p.right == null){
            TreeNode child = (p.left != null) ? p.left : p.right;
            if (parent == null){
                return child;
            }else {
                if (p == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                return root;
            }
        } else {
          TreeNode s = p.right;
          TreeNode sParent = p;
          while (s.left!= null){
              sParent = s;
              s = s.left;
          }
          p.val = s.val;
          if (sParent.left == s){
              sParent.left = s.right;
          }else {
              sParent.right = s.right;
          }
      }
      return root;
    }


    // 打印树的方法，这里使用简单的前序遍历
    public static void printTree(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
