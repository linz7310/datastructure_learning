package com.lin.datastructure.binarytree;

/**
 * ClassName E05Leetcode104_1
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E05Leetcode104_1 {
    public int depthMax(TreeNode node){
        if (node == null){
            return 0;
        }
        int d1 = depthMax(node.left);
        int d2 = depthMax(node.right);
        return Integer.max(d2,d1)+1;
    }
}
