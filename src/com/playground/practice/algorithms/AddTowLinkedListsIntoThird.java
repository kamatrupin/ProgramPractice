package com.playground.practice.algorithms;

public class AddTowLinkedListsIntoThird {

    public static void main(String args []) {
        LLNode result = new LLNode();
        LLNode head1 = new LLNode(2);
        head1.next = new LLNode(4);
        head1.next.next = new LLNode(3);

        LLNode head2 = new LLNode(5);
        head2.next = new LLNode(6);
        head2.next.next = new LLNode(4);

        addLists(head1, head2, result, 0);

        LLNode current = result;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void addLists(LLNode l1, LLNode l2, LLNode resultNode, int carry) {

        if(l1 == null && l2 == null && carry == 0) {
            resultNode = null;
            return;
        } else {
            resultNode.next = new LLNode();
        }

        int valL1 = l1 == null ? 0 : l1.value;
        int valL2 = l2 == null ? 0 : l2.value;

        // Add both nodes
        int res = valL1 + valL2 + carry;
        carry = res / 10;
        int resVal = res % 10;
        resultNode.value = resVal;

        addLists(l1.next == null ? null : l1.next, l2.next == null ? null : l2.next, resultNode.next, carry);
    }

    static class LLNode {
        int value;
        LLNode next = null;

        LLNode() {}

        LLNode(int value) {
            this.value = value;
        }
    }
}
