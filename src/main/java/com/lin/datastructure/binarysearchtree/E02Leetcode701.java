package com.lin.datastructure.binarysearchtree;


import com.lin.datastructure.binarytree.TreeNode;

/**
 * ClassName E02Leetcode701
 * Package com.lin.datastructure.binarysearchtree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/13
 */
public class E02Leetcode701 {
    public TreeNode insertIntoBST (com.lin.datastructure.binarytree.TreeNode node, int val){
        if (node == null){
            return new com.lin.datastructure.binarytree.TreeNode(val);
        }
        if (val< node.val){
            node.left = insertIntoBST(node.left,val);
        } else if (node.val < val){
            node.right = insertIntoBST(node.right,val);
        }
        return node;

    }
    public TreeNode insertIntoBST1 (com.lin.datastructure.binarytree.TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode node = root;
        while (node != null) {
            if (val < node.val) {
                parent = node;
                node = node.left;
            } else if (val > node.val) {
                parent = node;
                node = node.right;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if (root == null){
            return newNode;
        }
           else if (val>parent.val){
                parent.right = newNode;
            }else parent.left = newNode;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode( new TreeNode(null, 2, new TreeNode(3)),2, new TreeNode(6));
        new E02Leetcode701().insertIntoBST(root, 1);
    }
}
