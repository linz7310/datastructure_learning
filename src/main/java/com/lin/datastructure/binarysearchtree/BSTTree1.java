package com.lin.datastructure.binarysearchtree;

import com.lin.datastructure.binarytree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName BSTTree1
 * Package com.lin.datastructure.binarysearchtree
 * Description:
 *
 * @Author: Lin
 * @Creat: 2024/4/9
 */
public class BSTTree1 {
    BSTNode root;
    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;


        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Object get(int key) {

        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public Object min() {
        return min(root);
    }

    public Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }
    public Object max(){
        return max(root);
    }

    public Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }
    public Object predecessor(int key){
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p!=null){
            if (key<p.key){
                p = p.left;
            }else if(key> p.key) {
                ancestorFromLeft = p;
                p = p.right;
            }else {
                break;
            }
        }
        if (p == null){
            return null;
        }
        if (p.left !=null){
            return max(p.left);
        }
        return ancestorFromLeft != null ?
                ancestorFromLeft.value : null;
    }
    public Object successor(int key){
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p!=null){
            if (key< p.key){
                p=p.left;
            }else if(key> p.key){
                p= p.right;
            }else {
                break;
            }
        }
        if (p==null){
            return null;
        }
        if (p.right!=null){
            return min(p.right);
        }
        return ancestorFromRight != null ?
                ancestorFromRight.value : null;
    }

    public void put(int key, Object value){
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null){
            parent = node;
            if (key < node.key){
                node = node.left;
            }else if(node.key < key){
                node = node.right;
            }else {
                node.value = value;
                return;
            }
        }
        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }
        if (key< parent.key){
            parent.left = new BSTNode(key,value);
        }else if (key> parent.key){
            parent.right = new BSTNode(key,value);
        }

    }
    public Object remove(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 删除操作
        if (p.left == null) {
            shift(parent, p, p.right); // 情况1
        } else if (p.right == null) {
            shift(parent, p, p.left); // 情况2
        } else {
            // 情况4
            // 4.1 被删除节点找后继
            BSTNode s = p.right;
            BSTNode sParent = p; // 后继父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为 s
            if (sParent != p) { // 不相邻
                // 4.2 删除和后继不相邻, 处理后继的后事
                shift(sParent, s, s.right); // 不可能有左孩子
                s.right = p.right;
            }
            // 4.3 后继取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p=p.left;
            }else {
                BSTNode pop = stack.pop();
                if (pop.key < key){
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.right;
            }

        }
        return result;
    }

    // 找 > key 的所有 value
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    // 找 >= key1 且 <= key2 的所有值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }



}
