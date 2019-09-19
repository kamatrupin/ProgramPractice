package com.playground.practice.algorithms.tree;


public class BinaryTreeTraversal {

    private static void inOrder(TreeNode node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    private static void preOrder(TreeNode node) {
        if(node == null) return;

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void preOrder(TreeNode node, int depth, int i) {
        if(node == null) return;

        System.out.println(node.val + " (" + depth + ") i=" + i);
        depth++;
        i++;
        preOrder(node.left, depth, i);
        if(node.left != null) {
            i++;
            depth--;
            System.out.println(node.val + " (" + depth + ") i=" + i);
            depth++;
        }
        preOrder(node.right, depth, i);
        if(node.right != null) {
            i++;
            depth--;
            System.out.println(node.val + " (" + depth + ") i=" + i);
            depth++;
        }
    }

    private static void postOrder(TreeNode node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

//        System.out.println("In Order");
//        inOrder(node);

        System.out.println("Pre Order");
        preOrder(node, 0, 0);

//        System.out.println("Post Order");
//        postOrder(node);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
