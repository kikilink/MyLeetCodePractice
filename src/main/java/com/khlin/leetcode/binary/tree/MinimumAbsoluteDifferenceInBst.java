package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.DefaultBinaryTreeHelper;
import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 二叉搜索树的最小绝对差
 *
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 
 * 示例 :
 * 
 * 输入:
 * 
 * 1 \ 3 / 2
 * 
 * 输出: 1
 * 
 * 解释: 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。 注意: 树中至少有2个节点。
 */
public class MinimumAbsoluteDifferenceInBst {

	/**
	 * 找出任意两个节点的最小绝对差，如果可以排序，那么只要排序后，遍历判断两个元素间的差即可。
	 * 而二叉搜索树，实际上是已经排好序的。利用这一特点，只需要进行中序遍历，即可计算。
	 */
	public static class Solution {
		public int getMinimumDifference(TreeNode root) {
			TreeNode minDifference = new TreeNode(-1);
			inOrder(root, new ArrayDeque<>(), minDifference);
			return minDifference.val;
		}

		private void inOrder(TreeNode root, Deque<Integer> sortedValues,
				TreeNode minDifference) {
			if (null == root) {
				return;
			}

			inOrder(root.left, sortedValues, minDifference);

			int value = root.val;
			if (!sortedValues.isEmpty()) {
				int last = sortedValues.getLast();
				// 说明是第一个节点
				if (-1 == minDifference.val) {
					minDifference.val = Math.abs(value - last);
				} else {
					minDifference.val = Math.min(Math.abs(value - last),
							minDifference.val);
				}
			}
			sortedValues.addLast(value);

			inOrder(root.right, sortedValues, minDifference);
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = DefaultBinaryTreeHelper
				.stringToTreeNode("[236,104,701,null,227,null,911]");
		System.out.println(new Solution().getMinimumDifference(treeNode));
	}
}
