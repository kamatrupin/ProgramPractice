package com.playground.practice.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeNaryTree {

    private static List<Integer> serRes = new ArrayList<>();
    private static int index = 0;
    private static void serializeNaryTree(NaryTreeNode root) {
        if(root == null)
            return;

        serRes.add(root.val);
        if(root.children == null) {
            serRes.add(-1);
            return;
        }

        int children = root.children.size();
        serRes.add(children);

        for(NaryTreeNode child : root.children) {
            serializeNaryTree(child);
        }
    }

    private static NaryTreeNode deserializeNaryTree() {
        int val = serRes.get(index);

        if(index > serRes.size() - 1 || val == -1) {
            index++;
            return null;
        }

        NaryTreeNode node = new NaryTreeNode(val);
        index++;
        int children = serRes.get(index);
        index++;

        for(int i=0; i<children; i++) {
            node.addChild(deserializeNaryTree());
        }

        return node;
    }

    private static void levelOrder(NaryTreeNode root) {
        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(root.val);

        while(!queue.isEmpty()) {
            int elements = queue.size();

            while(elements > 0) {
                NaryTreeNode node = queue.poll();

                List<NaryTreeNode> children = node.children;
                if(children == null || children.isEmpty()) {
                    break;
                }

                for(NaryTreeNode child : children) {
                    System.out.print(child.val + " ");
                    queue.add(child);
                }

                elements--;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        NaryTreeNode node1 = new NaryTreeNode(1);
        NaryTreeNode node2 = new NaryTreeNode(2);
        NaryTreeNode node3 = new NaryTreeNode(3);
        NaryTreeNode node4 = new NaryTreeNode(4);
        NaryTreeNode node5 = new NaryTreeNode(5);
        NaryTreeNode node6 = new NaryTreeNode(6);

        node1.addChild(node3);
        node1.addChild(node2);
        node1.addChild(node4);

        node3.addChild(node5);
        node3.addChild(node6);

        levelOrder(node1);

        serializeNaryTree(node1);
        System.out.println("Serialized form - " + serRes);

        System.out.println("Deserialized form -");
        levelOrder(deserializeNaryTree());
    }
}
