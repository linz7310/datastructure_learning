package com.lin.datastructure.binarytree;

/**
 * ClassName E07Leetcode226
 * Package com.lin.datastructure.binarytree
 * Description: invert a binary tree
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E07Leetcode226 {
    public TreeNode invertTree(TreeNode root){
        fn(root);
        return root;
    }
    private static void fn(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode t = node.right;
        node.right = node.left;
        node.left = t;
        fn(node.right);
        fn(node.left);
    }
}
