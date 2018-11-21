package com.khlin.data.structure;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

public class BinarySearchTreeHelper {

	// 判断数组是否是后序遍历的二叉搜索树
	public static boolean isPostOrder(int[] nums) {
		if (null == nums || nums.length == 0) {
			return false;
		}
		return isPostOrder(nums, 0, nums.length - 1);
	}

	private static boolean isPostOrder(int[] nums, int start, int end) {
		if (end - start < 2) {
			return true;
		}

		int root = nums[end];

		int cursor = start;

		// 找到临界点
		while (cursor <= end - 1) {
			if (nums[cursor] > root) {
				break;
			}
			cursor++;
		}

		// 再判断右边的节点是不是都比父节点小
		for (; cursor <= end - 1; cursor++) {
			if (nums[cursor] < root) {
				return false;
			}
		}

		// 递归判断左右子树
		return isPostOrder(nums, start, cursor - 1)
				&& isPostOrder(nums, cursor, end - 1);
	}

	// 根据后序遍历数组创建一棵二叉搜索树
	public static TreeNode buildBSTFromPostOrderArray(int[] array) {
		return buildBSTFromPostOrderArray(array, 0, array.length - 1);
	}

	private static TreeNode buildBSTFromPostOrderArray(int[] array, int start,
			int end) {
		if (start == end) {
			return new TreeNode(array[start]);
		}

		TreeNode root = new TreeNode(array[end]);

		int cursor = start;
		while (cursor <= end - 1) {
			if (array[cursor] > root.val) {
				break;
			}
			cursor++;
		}

		// 说明找到临界点，左树存在
		if (cursor > start) {
			root.left = buildBSTFromPostOrderArray(array, start, cursor - 1);
		}

		if (cursor <= end - 1) {
			root.right = buildBSTFromPostOrderArray(array, cursor, end - 1);
		}

		return root;

	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 5, 6, 4 };
		int[] nums2 = new int[] { 1, 7, 5, 2, 6, 4 };
		System.out.println(BinarySearchTreeHelper.isPostOrder(nums1));
		System.out.println(BinarySearchTreeHelper.isPostOrder(nums2));

		TreeNode root = BinarySearchTreeHelper
				.buildBSTFromPostOrderArray(new int[] { 1, 3, 2, 6, 8, 7, 5 });

		System.out.println("xxx");
	}
}
