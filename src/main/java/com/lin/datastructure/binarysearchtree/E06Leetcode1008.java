package com.lin.datastructure.binarysearchtree;

/**
 * ClassName: E06Leetcode1008
 * Package: com.lin.datastructure.binarysearchtree
 * Description
 * Authot: Lin
 * Creat: 2024/7/2-12:39
 */
public class E06Leetcode1008 {
//    public TreeNode bstFromPreorder(int[] preorder) {
//        TreeNode root = new TreeNode(preorder[0]);
//        for (int i = 1; i < preorder.length; i++) {
//            root = insert(root,preorder[i]);
//        }
//        return root;
//
//
//    }
//    public TreeNode insert(TreeNode node, int val){
//        if (node == null){
//            return new TreeNode(val);
//        }
//        if (node.val>val){
//            node.left = insert(node.left,val);
//        }else if(node.val < val){
//            node.right = insert(node.right,val);
//        }
//        return node;
//    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return partition(preorder,0,preorder.length-1);
    }
    public TreeNode partition(int[] preorder, int start, int end) {
        if (start > end ){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start +1;
        while (index <= preorder.length-1){
            if (preorder[index]>preorder[start]){
                break;
            }
            index++;
        }
        root.left = partition(preorder,start+1,index-1);
        root.right = partition(preorder,index,end);
        return root;
    }
    public static void main(String[] args) {
        /*
                8
               / \
              5   10
             / \   \
            1   7  12
         */
        TreeNode t1 = new E06Leetcode1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
//        TreeNode t1 = new E06Leetcode1008().bstFromPreorder(new int[]{8, 5, 7});
        TreeNode t2 = new TreeNode(8, new TreeNode(5, new TreeNode(1), new TreeNode(7)), new TreeNode(10, null, new TreeNode(12)));
        System.out.println(isSameTree(t1, t2));
    }
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
