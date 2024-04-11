package com.lin.datastructure.binarytree;

import java.util.Arrays;

/**
 * ClassName E10Leetcode106
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/4
 */
public class E10Leetcode106 {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length==0){
            return null;
        }
        int rootValue = postOrder[postOrder.length-1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i]==rootValue){
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i);
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1);
                root.right=buildTree(inRight,postRight);
                root.left=buildTree(inLeft,postLeft);
                break;
            }
        }
        return root;
    }
}
