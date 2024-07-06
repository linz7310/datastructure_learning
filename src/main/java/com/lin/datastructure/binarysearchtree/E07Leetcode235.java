package com.lin.datastructure.binarysearchtree;

/**
 * ClassName: E07Leetcode235
 * Package: com.lin.datastructure.binarysearchtree
 * Description
 * Authot: Lin
 * Creat: 2024/7/3-16:34
 */
public class E07Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while (p.val < a.val && q.val < a.val || p.val > a.val && q.val > a.val) {
            if (q.val < a.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode t1 = new E07Leetcode235().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(t1.val); // 应为 6
        TreeNode t2 = new E07Leetcode235().lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5));
        System.out.println(t2.val); // 应为 4
    }

}