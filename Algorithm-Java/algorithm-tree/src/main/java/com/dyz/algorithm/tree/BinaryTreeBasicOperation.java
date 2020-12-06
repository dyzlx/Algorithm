package com.dyz.algorithm.tree;

public class BinaryTreeBasicOperation {
    public static void main(String[] args) {

    }

    public static void prevOrder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        prevOrder(root.leftNode);
        prevOrder(root.rightNode);
    }

    public static void inOrder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        prevOrder(root.leftNode);
        prevOrder(root.rightNode);
    }

    public static void postOrder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        prevOrder(root.leftNode);
        prevOrder(root.rightNode);
        System.out.print(root.value + " ");
    }

    public static int treeHeight1(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeHeight1(root.leftNode);
        int right = treeHeight1(root.rightNode);
        return left > right ? left+1 : right+1;
    }

    public static int treeHeight2(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(treeHeight2(root.leftNode), treeHeight2(root.rightNode)) + 1;
    }

    public static BinaryTreeNode findNode(BinaryTreeNode root, int value) {
        if(root == null) {
            return null;
        }
        if(root.value == value) {
            return root;
        }
        BinaryTreeNode left = findNode(root.leftNode, value);
        if(left != null) {
            return left;
        }
        BinaryTreeNode right = findNode(root.rightNode, value);
        if(right != null) {
            return right;
        }
        return null;
    }

    public static void invertTree(BinaryTreeNode root) {
        if(root == null) {
            return ;
        }
        BinaryTreeNode temp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = temp;
        invertTree(root.leftNode);
        invertTree(root.rightNode);
    }
}
