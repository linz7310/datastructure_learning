package com.lin.datastructure.binarysearchtree;

import com.lin.datastructure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * ClassName E04Leetcode98
 * Package com.lin.datastructure.binarysearchtree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/13
 */
public class E04Leetcode98 {
    // 解法1. 中序遍历非递归实现 1ms
    public boolean isValidBST1(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode pop = stack.pop();
                if (prev >= pop.val){
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }
// 解法2. 中序遍历递归实现(全局变量记录 prev) 0ms

    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST2(node.left);
        if (!a) {
            return false;
        }
        if (prev >= node.val) {
            return false;
        }
        prev = node.val;
        return isValidBST2(node.right);
    }
}
