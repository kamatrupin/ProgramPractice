package com.playground.practice.onit;

import java.util.ArrayList;
import java.util.List;

public class PrintTreeNodes {

    public static void main(String[] args) {
        Node root = magicallyGetTreeNode("onit");
        printTreeNodes(root, 1);
    }

    private static void printTreeNodes(Node node, int level) {
        node.printName();

        if(node.getChildren() != null) {
            for(Node child : node.getChildren()) {
                // Add number of '\t' as that of the level
                printLevel(level);
                printTreeNodes(child, level+1);
            }
        }
    }

    public static void printLevel(int level) {
        for(int i=0; i<level; i++) {
            System.out.print("\t");
        }
    }

    private static Node magicallyGetTreeNode(String onit) {
        List<Node> devChildren = new ArrayList<>();
        Node eric = new Node("eric", null);
        Node iuri = new Node("iuri", null);
        Node robert = new Node("robert", null);
        devChildren.add(eric);
        devChildren.add(iuri);
        devChildren.add(robert);

        List<Node> usChildren = new ArrayList<>();
        Node joe = new Node("joe", null);
        Node jim = new Node("jim", null);
        usChildren.add(joe);
        usChildren.add(jim);
        Node us = new Node("us", usChildren);

        List<Node> salesChildren = new ArrayList<>();
        Node europe = new Node("europe", null);
        Node asia = new Node("asia", null);
        salesChildren.add(us);
        salesChildren.add(europe);
        salesChildren.add(asia);

        List<Node> oninChildren = new ArrayList<>();
        Node sales = new Node("sales", salesChildren);
        Node dev = new Node("dev", devChildren);
        oninChildren.add(dev);
        oninChildren.add(sales);

        return new Node("onit", oninChildren);
    }
}
