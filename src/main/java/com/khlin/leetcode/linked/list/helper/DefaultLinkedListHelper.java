package com.khlin.leetcode.linked.list.helper;

public class DefaultLinkedListHelper {
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	public static ListNode buildList(int[] vals) {

		ListNode head = new ListNode(vals[0]);
		ListNode cursor = head;
		for (int i = 1; i <= vals.length - 1; i++) {
			ListNode newNode = new ListNode(vals[i]);
			cursor.next = newNode;
			cursor = newNode;
		}

		return head;
	}

	public static ListNode buildRangeList(int start, int end) {
		int[] vals = new int[end - start + 1];
		for (int i = 0; i <= vals.length - 1; i++) {
			vals[i] = start++;
		}

		return buildList(vals);
	}

	public static void printNodes(ListNode head) {
		if (null == head) {
			return;
		}
		do {
			System.out.println(head.val);
			head = head.next;
		} while (null != head);
	}
}
