package com.lin.datastructure.binarytree;

/**
 * ClassName E04Leetcode101
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E04Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left==null && right == null){
            return true;
        }else if (left ==null || right == null){
            return false;
        }else if(left.val!=right.val){
            return false;
        }
        return check(left.left,right.right) && check(left.right,right.left) ;
    }
}
