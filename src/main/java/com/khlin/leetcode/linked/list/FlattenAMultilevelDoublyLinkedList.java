package com.khlin.leetcode.linked.list;

import com.khlin.leetcode.linked.list.helper.DoublyLinkedListHelper;
import com.khlin.leetcode.linked.list.helper.DoublyLinkedListHelper.Node;

/**
 * 扁平化多级双向链表
 * 
 * 
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: 1---2---3---4---5---6--NULL
 *				 |
 *				 7---8---9---10--NULL
 *					 |
 *				 	11--12--NULL
 * 
 * 输出: 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenAMultilevelDoublyLinkedList {

	public static class Solution {
		public Node flatten(Node head) {
			recursiveFlatten(head);
			return head;
		}

		private Node recursiveFlatten(Node head) {
			if (null == head) {
				return head;
			}
			Node cursor = head;
			Node prev = cursor.prev;
			while (null != cursor) {
				// 优先遍历子节点
				if (null != cursor.child) {
					Node childLast = recursiveFlatten(cursor.child);

					// 游标节点的下一个节点变为子节点，子节点的前一个节点变为当前游标节点。
					Node tempNext = cursor.next;
					cursor.next = cursor.child;
					cursor.child.prev = cursor;
					cursor.child = null;
					// 把原下一个节点绑定到子链表的下一个
					childLast.next = tempNext;
					if (null != tempNext) {
						tempNext.prev = childLast;
					}

					// 继续遍历
					prev = childLast;
					cursor = childLast.next;
				} else {
					prev = cursor;
					cursor = cursor.next;
				}
			}

			return prev;
		}
	}

	public static void main(String[] args) {
		case1();
		System.out.println("===========");
		case2();
	}

	private static void case1() {
		Node head = DoublyLinkedListHelper.buildRangeList(1, 6);

		Node realHead = head;

		Node head2 = DoublyLinkedListHelper.buildRangeList(7, 10);

		Node head3 = DoublyLinkedListHelper.buildRangeList(11, 12);

		for (int i = 1; i < 1; i++) {
			head = head.next;
		}

		head.child = head2;

		for (int i = 1; i < 1; i++) {
			head2 = head2.next;
		}

		head2.child = head3;

		DoublyLinkedListHelper.printNodes(new Solution().flatten(realHead));
	}

	private static void case2() {
		Node head = DoublyLinkedListHelper.buildRangeList(1, 6);

		Node realHead = head;

		Node head2 = DoublyLinkedListHelper.buildRangeList(7, 10);

		Node head3 = DoublyLinkedListHelper.buildRangeList(11, 12);

		for (int i = 1; i < 6; i++) {
			head = head.next;
		}

		head.child = head2;

		for (int i = 1; i < 4; i++) {
			head2 = head2.next;
		}

		head2.child = head3;

		DoublyLinkedListHelper.printNodes(new Solution().flatten(realHead));
	}
}
