package com.playground.practice.onit;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> children;

    public Node(String name, List<Node> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void printName() {
        System.out.println(getName());
    }

    public void addChild(Node node) {
        if(this.children == null) {
            children = new ArrayList<>();
        }
    }
}
