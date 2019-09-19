package com.playground.practice.algorithms;

import com.playground.practice.linkedlist.Node;

/**
 * Created by rkamat on 9/12/2018.
 */
public class MergeSortedLinkedLists {

    public void mergeLists(Node... lists) {

    }

    public static void main(String args []) {
        Node linkedList1 = new Node(1);
        linkedList1.next = new Node(3);
        linkedList1.next.next = new Node(5);
        linkedList1.next.next.next = new Node(7);

        Node linkedList2 = new Node(2);
        linkedList2.next = new Node(4);
        linkedList2.next.next = new Node(6);
        linkedList2.next.next.next = new Node(8);
    }
}
