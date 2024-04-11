package com.lin.datastructure.binarytree;

import java.util.LinkedList;

/**
 * ClassName E08ExpressionTree
 * Package com.lin.datastructure.binarytree
 * Description:
 * Constructing an expression tree from a suffix expression
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E08ExpressionTree {
    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }

        /*
        中缀表达式           (2-1)*3
        后缀（逆波兰）表达式   21-3*

        1.遇到数字入栈
        2.遇到运算符, 出栈两次, 与当前节点建立父子关系, 当前节点入栈

        栈
        |   |
        |   |
        |   |
        _____

        表达式树
            *
           / \
          -   3
         / \
        2   1

        21-3*
     */

    public TreeNode constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+", "-", "*", "/" -> {
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode(t);
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                }
                default -> {
                    stack.push(new TreeNode(t));
                }
            }
        }
        return stack.peek();
    }
    }


