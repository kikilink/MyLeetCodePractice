package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper;
import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 删除链表的倒数第N个节点
 * 
 * 
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {

	public static class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode fast = head;

			// 快指针应该比链表头快n个位置。
			int i = 1;
			while (i <= n - 1) {
				if (null == fast) {
					return head;
				}
				fast = fast.next;
				i++;
			}
			if (null == fast) {
				return head;
			}

			ListNode dumpHead = new ListNode(0);
			dumpHead.next = head;

			// 慢指针应该比要删除的位置前一个位置，这样才可以通过重置next删除目标节点。
			ListNode slow = dumpHead;
			while (null != fast.next) {
				fast = fast.next;
				slow = slow.next;
			}

			ListNode next = slow.next.next;
			slow.next.next = null;
			slow.next = next;
			return dumpHead.next;
		}

	}

	public static void main(String[] args) {
		ListNode head = DefaultLinkedListHelper.buildRangeList(1, 6);

		ListNode reverseHead = new Solution().removeNthFromEnd(head, 2);

		DefaultLinkedListHelper.printNodes(reverseHead);
	}
}
