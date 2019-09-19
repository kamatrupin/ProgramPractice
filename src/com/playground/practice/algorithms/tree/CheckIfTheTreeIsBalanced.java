package com.playground.practice.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTheTreeIsBalanced {

    private static void printPreorder(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.println(node.val);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(true) {

            int levelCount = queue.size();
            if(levelCount == 0) break;

            while(levelCount > 0) {
                TreeNode intNode =  queue.poll();
                System.out.print(intNode.val + " ");

                if(intNode.left != null)
                    queue.add(intNode.left);

                if(intNode.right != null)
                    queue.add(intNode.right);

                levelCount--;
            }

//            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        node.right.right.left = new TreeNode(9);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(8);

        levelOrder(node);

    }

    private static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
