package com.lin.datastructure.binarytree;

import com.lin.datastructure.stack.LinkedListStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName E01Leetcode144
 * Package com.lin.datastructure.binarytree
 * Description:Binary tree forward traversal (value, left, right)
 *
 * @Author: Lin
 * @Creat: 2024/4/3
 */
public class E01Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;
        ArrayList<Integer> result = new ArrayList<>();
        while (curr!=null||!stack.isEmpty() ){
            if (curr!=null ){
                stack.push(curr);
//                result.add(curr.val);
                curr=curr.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==null){
                    pop = stack.pop();
                    result.add(pop.val);
                }else if(peek.right== pop){
                    pop = stack.pop();
                }else {

                    curr=peek.right;
                    result.add(peek.val);

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
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        System.out.println(new E01Leetcode144().preorderTraversal(root));

        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            if (curr!=null) {
                stack.push(curr);
//                colorPrintln("去: " + curr.val, 31);
                curr = curr.left;
            }else {
                TreeNode pop = stack.pop();
                curr = pop.right;
                colorPrintln("回: " + pop.val,34);

            }
        }


}
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}