package com.lin.datastructure.binarysearchtree;



/**
 * ClassName: E05Leetcode938
 * Package: com.lin.datastructure.binarysearchtree
 * Description
 * Authot: Lin
 * Creat: 2024/7/2-12:09
 */
public class E05Leetcode938 {


    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        // 在范围内
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }







    public static void main(String[] args) {
        /*
                 10
                /  \
               5    15
              / \    \
             3   7    18        low=7  high=15
         */
        TreeNode n1 = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        TreeNode n2 = new TreeNode(15, null, new TreeNode(18));
        TreeNode root = new TreeNode(10, n1, n2);

        int sum = new E05Leetcode938().rangeSumBST(root, 7, 15);
        System.out.println(sum); // 应为 32
    }
}
