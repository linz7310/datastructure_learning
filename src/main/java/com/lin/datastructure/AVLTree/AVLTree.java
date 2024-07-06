package com.lin.datastructure.AVLTree;

/**
 * ClassName: AVLTree
 * Package: com.lin.datastructure.AVLTree
 * Description
 * Authot: Lin
 * Creat: 2024/7/5-11:20
 */
public class AVLTree {
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    private int bf(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    private AVLNode rightRotate(AVLNode red) {
        AVLNode yellow = red.left;
        red.left = yellow.right;
        yellow.right = red;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRotate(AVLNode red) {
       AVLNode yellow =  red.right;
        red.right = yellow.left;
        yellow.left = red;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLNode rightLeftRotate(AVLNode node) {
      node.right =   rightRotate(node.right);
      return leftRotate(node);
    }
    private AVLNode balance(AVLNode node){
        if (node == null){
            return null;
        }
        int bf = bf(node);
        if (bf > 1 && bf(node.left) >= 0) { // LL
            return rightRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) { // LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) { // RL
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) { // RR
            return leftRotate(node);
        }
        return node;
    }
    AVLNode root;
    public void put(int key, Object value){
        root = doPut(root, key, value);
    }

    private AVLNode doPut(AVLNode node, int key, Object value){
        //1. 找到空位，创建新节点
        if (node == null){
            return new AVLNode(key,value);
        }
        //2.key 存在 进行更新
        if (key == node.key){
            node.value = value;
            return node;
        }
        //3. 继续查找
        if (key< node.key){
            doPut(node.left,key,value);
        }else {
            doPut(node.right, key,value);
        }
        updateHeight(node);
        return balance(node);
    }


    public void remove(int key) {
        root = doRemove(root, key);
    }

    private AVLNode doRemove(AVLNode node, int key) {
        // 1. node == null
        if (node == null) {
            return null;
        }
        // 2. 没找到 key
        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (node.key < key) {
            node.right = doRemove(node.right, key);
        } else {
            // 3. 找到 key  1) 没有孩子 2) 只有一个孩子 3) 有两个孩子
            if (node.left == null && node.right == null){
                return null;
            }else if (node.left == null){
                node = node.right;
            }else if (node.right == null){
                node = node.left;
            }else {
                AVLNode s = node.right;
                if (s.left!= null){
                    s = s.left;
                }
               s.right= doRemove(node.right,s.key);
                s.left = node.left;
                s = s.left;
            }
        }
        // 4. 更新高度
        updateHeight(node);
        // 5. balance
        return balance(node);
    }































}