package com.playground.practice.algorithms.tree;


public class CheckBalancedTree {

    private static boolean isTreeBalanced(TreeNode node) {
        if(node == null) return true;

        return checkIfTreeIsBalanced(node) > -1;
    }

    private static int checkIfTreeIsBalanced(TreeNode node) {
        if(node == null) return 0;

        int h1 = checkIfTreeIsBalanced(node.left);
        int h2 = checkIfTreeIsBalanced(node.right);

        if(h1 == -1 || h2 == -1) return -1;
        if(Math.abs((h1 - h2)) > 1) return -1;

        if(h1 > h2) return h1 + 1;
        return h2 + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(8);

        if(isTreeBalanced(node)) System.out.println("Tree is balanced");
        else System.out.println("Tree is not balanced");
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
