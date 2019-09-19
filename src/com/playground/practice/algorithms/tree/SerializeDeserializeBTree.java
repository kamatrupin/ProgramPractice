package com.playground.practice.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBTree {

    private static int index = 0;
    private static List<Integer> serializeBTree(TreeNode node) {
        // preorder traversal to serialize into an array
        List<Integer> array = new ArrayList<>();
        preorderTraversal(node, array);
        return array;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> array) {
        if(node == null) {
            array.add(-1);
            return;
        }

        array.add(node.val);
        preorderTraversal(node.left, array);
        preorderTraversal(node.right, array);
    }

    // [20, 8, 4, -1, -1, 12, 10, -1, -1, 14, -1, -1, 22, -1, -1]
    //         ^
    // index = 2
    // val = 20, 8, 4
    private static TreeNode deSerialize(List<Integer> array) {
        Integer val = array.get(index);
        if(index > array.size() - 1 || val == -1) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(val);
        index++;

        node.left = deSerialize(array);
        node.right = deSerialize(array);

        return node;
    }

    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

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
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(22);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(14);

        // Serialize
        List<Integer> serRes = serializeBTree(node);
        System.out.println(serRes);

        // Deserialize
        TreeNode rootNode = deSerialize(serRes);
        levelOrder(rootNode);
    }
}
