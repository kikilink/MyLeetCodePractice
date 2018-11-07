package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 环形链表
 * 
 * 
 * 给定一个链表，判断链表中是否有环。
 * 
 * 进阶： 你能否不使用额外空间解决此题？
 */
public class LinkedListCycle {

	public static class Solution {
		public boolean hasCycle(ListNode head) {
			if (null == head || null == head.next) {
				return false;
			}

			ListNode slow = head;
			ListNode fast = head.next;
			while (null != fast.next && null != fast.next.next) {
				fast = fast.next.next;
				slow = slow.next;

				if (fast == slow) {
					return true;
				}
			}

			return false;
		}
	}
}
