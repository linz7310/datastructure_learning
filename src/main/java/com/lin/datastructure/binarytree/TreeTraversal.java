package com.lin.datastructure.binarytree;

/**
 * ClassName TreeTraversal
 * Package com.lin.datastructure.binarytree
 * Description: recursion for traversal
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class TreeTraversal {
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();
    }
    static void preOrder(TreeNode node){
        if (node == null ){
            return;
        }
        System.out.print(node.val + "\t"); // 值
        preOrder(node.left); // 左
        preOrder(node.right); // 右
    }
    static void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left); // 左
        System.out.print(node.val + "\t"); // 值
        inOrder(node.right); // 右
    }

    static void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "\t"); // 值
    }
}
