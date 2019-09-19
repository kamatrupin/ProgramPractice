package com.playground.practice.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InorderSuccessor {

    private static BinaryTreeNode insert(BinaryTreeNode root, int value) {

        if(root == null)
            return new BinaryTreeNode(value);

        BinaryTreeNode temp = root;
        if(value < root.value) {
            BinaryTreeNode node = insert(root.left, value);
            temp.left = node;
            node.parent = temp;
        } else {
            BinaryTreeNode node = insert(root.right, value);
            temp.right = node;
            node.parent = temp;
        }

        return root;
    }

    private static void levelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                BinaryTreeNode node = queue.poll();
                System.out.print(node.value + " ");

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);

                size--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node = insert(null, 20);
        node = insert(node, 8);
        node = insert(node, 22);
        node = insert(node, 4);
        node = insert(node, 12);
        node = insert(node, 10);
        node = insert(node, 14);


        levelOrder(node);
    }
}
