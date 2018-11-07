package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 两数相加 II
 * 
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 
 * 
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 进阶:
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 示例:
 * 
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

	public static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			Deque<Integer> d1 = new ArrayDeque<>();
			Deque<Integer> d2 = new ArrayDeque<>();

			ListNode cursor = l1;
			while (null != cursor) {
				d1.addLast(cursor.val);
				cursor = cursor.next;
			}

			cursor = l2;
			while (null != cursor) {
				d2.add(cursor.val);
				cursor = cursor.next;
			}

			int carry = 0;
			ListNode last = null;
			ListNode dumpHead = new ListNode(0);
			while (!(d1.isEmpty() && d2.isEmpty())) {
				int num1 = d1.isEmpty() ? 0 : d1.removeLast();
				int num2 = d2.isEmpty() ? 0 : d2.removeLast();
				int addResult = num1 + num2 + carry;
				if (null == last) {
					last = new ListNode(addResult % 10);
					dumpHead.next = last;
				} else {
					ListNode newNode = new ListNode(addResult % 10);
					dumpHead.next = newNode;
					newNode.next = last;
					last = newNode;
				}
				carry = addResult >= 10 ? 1 : 0;
			}

			if (carry > 0) {
				ListNode newNode = new ListNode(carry);
				dumpHead.next = newNode;
				newNode.next = last;
			}
			return dumpHead.next;

		}
	}
}
