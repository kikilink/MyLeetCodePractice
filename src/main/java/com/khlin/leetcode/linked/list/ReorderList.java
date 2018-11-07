package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 重排链表
 * 
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

	public static class Solution {
		public void reorderList(ListNode head) {
			if (null == head || null == head.next) {
				return;
			}

			// 先找出中点
			ListNode slow = head;
			ListNode fast = head.next;
			while (null != fast.next) {
				fast = fast.next;
				slow = slow.next;
				if (null != fast.next) {
					fast = fast.next;
				} else {
					break;
				}
			}

			ListNode middle = slow.next;
			slow.next = null;

			// 将后面的元素读出
			Deque<ListNode> stack = new ArrayDeque<>();
			while (null != middle) {
				stack.addLast(middle);
				middle = middle.next;
			}

			// 间隔添加
			ListNode cursor = head;
			while (!stack.isEmpty()) {
				ListNode newNode = stack.removeLast();
				ListNode nextNode = cursor.next;
				cursor.next = newNode;
				newNode.next = nextNode;
				cursor = nextNode;
			}
		}
	}
}
