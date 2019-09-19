package com.playground.practice.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;

    public NaryTreeNode(int val) {
        this.val = val;
    }

    public void addChild(NaryTreeNode node) {
        if(children == null)
            children = new ArrayList<>();

        children.add(node);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
