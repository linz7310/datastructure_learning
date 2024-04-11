package com.lin.datastructure.binarytree;

import java.util.IdentityHashMap;

/**
 * ClassName E06Leetcode111_1
 * Package com.lin.datastructure.binarytree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E06Leetcode111_1 {
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left);
        int d2 = minDepth(node.right);
        if (d2 == 0 ){
            return d1 +1;
        }
        if(d1 == 0){
            return d2+1;
        }
        return Integer.min(d1,d2) +1;
    }
}