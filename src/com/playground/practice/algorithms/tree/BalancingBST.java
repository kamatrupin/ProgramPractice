package com.playground.practice.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class BalancingBST {

    private static void printPreorder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.val);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private static void storeTreeInArray(Node node, List<Node> nodes) {
        if(node == null) {
            return;
        }

        storeTreeInArray(node.left, nodes);
        nodes.add(node);
        storeTreeInArray(node.right, nodes);
    }

    private static Node balanceTree(int i, int j, List<Node> nodes) {
        if(i > j) return null;

        int mid = (i + j) / 2;
        Node node = nodes.get(mid);

        node.left = balanceTree(i, mid - 1, nodes);
        node.right = balanceTree(mid + 1, j, nodes);

        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(8);
        node.left.left = new Node(7);
        node.left.left.left = new Node(6);
        node.left.left.left.left = new Node(5);

        printPreorder(node);

        List<Node> nodes = new ArrayList<>();
        storeTreeInArray(node, nodes);

        // Sorted Array
        System.out.println("Sorted array=" + nodes);
        System.out.println("Start Balancing a tree");
        System.out.println("Balanced tree=");
        printPreorder(balanceTree(0, nodes.size() - 1, nodes));
    }

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
