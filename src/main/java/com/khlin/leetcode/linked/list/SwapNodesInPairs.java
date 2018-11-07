package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper;
import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 两两交换链表中的节点
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3. 说明:
 * 
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public static class Solution {
		public ListNode swapPairs(ListNode head) {
			ListNode dumpHead = new ListNode(1);
			dumpHead.next = head;
			ListNode cursor = dumpHead;
			while (cursor.next != null) {
				ListNode first = cursor.next;
				ListNode second = first.next;
				if (null == second) {
					return dumpHead.next;
				}
				ListNode next = second.next;
				second.next = first;
				first.next = next;

				cursor.next = second;
				cursor = first;
			}

			return (head = dumpHead.next);
		}
	}

	public static void main(String[] args) {
		ListNode head = DefaultLinkedListHelper.buildRangeList(1, 3);

		ListNode reverseHead = new Solution().swapPairs(head);

		DefaultLinkedListHelper.printNodes(reverseHead);
	}
}
