package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper;
import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 反转链表
 * 
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public static class Solution {
		public ListNode reverseList(ListNode head) {
			if (null == head) {
				return null;
			}
			return recursiveReverse(head, head, head.next);
		}

		/**
		 * 把反转完成的链表，当成一个整体。那么就有头和尾。头用来和下一个元素交换，尾要置空。
		 * 
		 * @param cursorStart
		 * @param cursorEnd
		 * @param next
		 * @return
		 */
		private ListNode recursiveReverse(ListNode cursorStart,
				ListNode cursorEnd, ListNode next) {
			if (null == next) {
				return cursorStart;
			}

			ListNode originalNode = next.next;
			next.next = cursorStart;
			cursorEnd.next = null;

			return recursiveReverse(next, cursorEnd, originalNode);
		}

	}

	public static void main(String[] args) {
		ListNode head = DefaultLinkedListHelper.buildRangeList(1, 20);

		ListNode reverseHead = new ReverseLinkedList.Solution()
				.reverseList(head);

		DefaultLinkedListHelper.printNodes(reverseHead);
	}
}
