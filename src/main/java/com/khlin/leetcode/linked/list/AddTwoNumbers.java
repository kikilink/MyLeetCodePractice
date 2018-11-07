package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DefaultLinkedListHelper.ListNode;

/**
 * 两数相加
 * 
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

	public static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode c1 = l1;
			ListNode c2 = l2;

			int carry = 0;
			ListNode dumpHead = new ListNode(0);
			ListNode lastNode = dumpHead;
			while (!(null == c1 && null == c2)) {
				int num1 = (null == c1 ? 0 : c1.val);
				int num2 = (null == c2 ? 0 : c2.val);
				int addResult = num1 + num2 + carry;

				ListNode newNode = new ListNode(addResult % 10);
				lastNode.next = newNode;
				lastNode = newNode;
				carry = addResult >= 10 ? 1 : 0;
				c1 = (null == c1 ? null : c1.next);
				c2 = (null == c2 ? null : c2.next);
			}

			if (carry > 0) {
				ListNode newNode = new ListNode(carry);
				lastNode.next = newNode;
			}
			return dumpHead.next;
		}
	}
}
