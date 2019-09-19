package com.playground.practice.linkedlist;

import com.playground.practice.linkedlist.Node;

/**
 * Created by rkamat on 3/22/2018.
 */
public class RLinkedList {
    private Node head;
    private Node current;

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        if(head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = current.next;
        }
    }
}
