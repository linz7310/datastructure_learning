package com.lin.datastructure.binarytree;

import java.util.LinkedList;

/**
 * ClassName E05Leetcode104_2
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E05Leetcode104_2 {
    public int maxDepth(TreeNode root){
        TreeNode curr = root;
        TreeNode pop = null;
        int depth = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curr!=null || !stack.isEmpty()){
            if (curr!= null) {
                stack.push(curr);
                int size = stack.size();
                if (size>depth){
                    depth = size;
                }
                curr = curr.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==null ){
                    pop = stack.pop();
                }else if (peek.right==pop){
                    pop = stack.pop();
                }else {
                    curr=peek.right;
                }

            }
        }
        return depth;
    }
}
