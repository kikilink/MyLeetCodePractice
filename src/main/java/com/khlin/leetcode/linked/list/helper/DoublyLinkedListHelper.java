package com.khlin.leetcode.linked.list.helper;

public class DoublyLinkedListHelper {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public static Node buildList(int[] vals) {

        Node head = new Node();
        head.val = vals[0];
        Node cursor = head;
        for (int i = 1; i <= vals.length - 1; i++) {
            Node newNode = new Node();
            newNode.val = vals[i];
            newNode.prev = cursor;
            cursor.next = newNode;
            cursor = newNode;
        }

        return head;
    }

    public static Node buildRangeList(int start, int end) {
        int[] vals = new int[end - start + 1];
        for (int i = 0; i <= vals.length - 1; i++) {
            vals[i] = start++;
        }

        return buildList(vals);
    }

    public static void printNodes(Node head) {
        if (null == head) {
            return;
        }
        do {
            System.out.println(head.val);
            head = head.next;
        } while (null != head);
    }
}
