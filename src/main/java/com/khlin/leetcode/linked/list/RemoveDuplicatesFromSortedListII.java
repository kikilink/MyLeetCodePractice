package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * 
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5 输出: 1->2->5 示例 2:
 * 
 * 输入: 1->1->1->2->3 输出: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

	public static class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode dumpHead = new ListNode(0);
			dumpHead.next = head;

			ListNode cursor = dumpHead;
			while (null != cursor.next) {
				ListNode subCursor = cursor.next;
				boolean duplicated = false;
				while (null != subCursor.next
						&& subCursor.val == subCursor.next.val) {
					duplicated = true;
					subCursor = subCursor.next;
				}

				if (duplicated) {
					cursor.next = subCursor.next;
				} else {
					cursor.next = subCursor;
					cursor = cursor.next;
				}
			}
			return dumpHead.next;
		}
	}
}
