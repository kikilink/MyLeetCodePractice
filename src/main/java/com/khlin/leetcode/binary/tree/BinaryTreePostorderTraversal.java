package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public static class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> list = new LinkedList<>();
			postorderTraversal(root, list);
			return list;
		}

		private void postorderTraversal(TreeNode root, List<Integer> list) {
			if (null == root) {
				return;
			}

			postorderTraversal(root.left, list);
			postorderTraversal(root.right, list);
			list.add(root.val);
		}
	}
}
