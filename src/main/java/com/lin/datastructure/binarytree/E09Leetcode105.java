package com.lin.datastructure.binarytree;

import java.util.Arrays;

/**
 * ClassName E09Leetcode105
 * Package com.lin.datastructure.binarytree
 * Description: Constructing a binary tree
 * from the result of a pre-middle order traversal
 *
 * @Author: Lin
 * @Creat: 2024/4/4
 */
public class E09Leetcode105 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        if (preOrder.length==0){
            return null;
        }
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i]==rootValue){
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, inOrder.length);
                root.left=buildTree(preLeft,inLeft);
                root.right= buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 3, 6, 7};
        int[] inOrder = {4, 2, 1, 6, 3, 7};
        TreeNode root = new E09Leetcode105().buildTree(preOrder, inOrder);
    }
}
