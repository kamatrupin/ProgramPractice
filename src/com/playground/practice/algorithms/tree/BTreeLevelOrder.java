package com.playground.practice.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeLevelOrder {

    private static void printLevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            int size = queue.size();
            while(size > 0) {
                TreeNode n = queue.poll();
                System.out.print(n.val + " ");

                if(n.left != null)
                    queue.add(n.left);

                if(n.right != null)
                    queue.add(n.right);

                size--;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        printLevelOrder(node);
    }
}
