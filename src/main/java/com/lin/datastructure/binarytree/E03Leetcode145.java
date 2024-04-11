package com.lin.datastructure.binarytree;

import com.lin.datastructure.stack.LinkedListStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName E03Leetcode145
 * Package com.lin.datastructure.binarytree
 * Description: Binary Tree Posterior Traversal (Left, Right, Value)
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E03Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();

    TreeNode curr = root; // 代表当前节点
    TreeNode pop = null; // 最近一次弹栈的元素

    List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
        if (curr != null) {
            stack.push(curr);
                // 待处理左子树
                curr = curr.left;
        } else {
            TreeNode peek = stack.peek();
            // 没有右子树
            if (peek.right == null) {
                pop = stack.pop();
                result.add(pop.val);
            }
            // 右子树处理完成
            else if (peek.right == pop) {
                pop = stack.pop();
                result.add(pop.val);
            }
            // 待处理右子树
            else {
                curr = peek.right;
            }
        }
    }
        return result;
}


public static void main(String[] args) {
        /*TreeNode root = new TreeNode(
                new TreeNode(2), 1, new TreeNode(3)
        );*/

    TreeNode root = new TreeNode(
            new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
            1,
            new TreeNode(new TreeNode(6), 3, new TreeNode(7))
    );
//        System.out.println(new E03Leetcode145().postorderTraversal(root));
        TreeNode pop = null;
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            if (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==null ||peek.right==pop){
                    pop = stack.pop();
                    System.out.println("回: " + pop.val);
                }else {
                    curr = peek.right;

                }
            }
        }


    }
}
