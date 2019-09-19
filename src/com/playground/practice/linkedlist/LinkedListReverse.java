package com.playground.practice.linkedlist;

import com.playground.practice.linkedlist.Node;

/**
 * Created by rkamat on 3/22/2018.
 */
public class LinkedListReverse {

    private static void printReverse(Node node) {
        if(node != null) {
            printReverse(node.next);
            System.out.println(node.val);
        }
    }

    private static void print(Node node) {
        if(node != null) {
            System.out.println(node.val);
            print(node.next);
        }
    }

    public static void main(String args []) {
        RLinkedList ll = new RLinkedList();
        ll.add(new Node(1));
        ll.add(new Node(2));
        ll.add(new Node(3));
        ll.add(new Node(4));

        System.out.println(" ---------------- Print ");
        print(ll.getHead());
        System.out.println(" ---------------- Print Rev ");
        printReverse(ll.getHead());
    }
}
