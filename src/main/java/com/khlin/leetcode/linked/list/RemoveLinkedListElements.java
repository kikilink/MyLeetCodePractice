package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 移除链表元素
 * 
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

	public static class Solution {
		public ListNode removeElements(ListNode head, int val) {
			if (null == head) {
				return head;
			}
			ListNode dumpHead = new ListNode(0);
			dumpHead.next = head;
			ListNode cursor = dumpHead;
			while (null != cursor.next) {
				if (cursor.next.val == val) {
					cursor.next = cursor.next.next;
				} else {
					cursor = cursor.next;
				}
			}
			return dumpHead.next;
		}
	}

	public static void main(String[] args) {

	}
}
