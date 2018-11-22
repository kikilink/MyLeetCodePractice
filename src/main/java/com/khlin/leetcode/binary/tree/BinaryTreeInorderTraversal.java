package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> list = new LinkedList<>();
			inorderTraversal(root, list);
			return list;
		}

		private void inorderTraversal(TreeNode root, List<Integer> list) {
			if (null == root) {
				return;
			}

			inorderTraversal(root.left, list);
			list.add(root.val);
			inorderTraversal(root.right, list);
		}
	}
}
