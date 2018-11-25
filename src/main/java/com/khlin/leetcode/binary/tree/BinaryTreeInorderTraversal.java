package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

		/**
		 * 非递归遍历
		 * 
		 * @param root
		 * @return
		 */
		public List<Integer> inorderTraversalNR(TreeNode root) {
			Stack<TreeNode> stack = new Stack<>();
			TreeNode cursor = root;

			List<Integer> list = new ArrayList<>();

			do {
				while (null != cursor) {
					stack.push(cursor);
					cursor = cursor.left;
				}

				if (!stack.isEmpty()) {
					TreeNode midNode = stack.pop();
					list.add(midNode.val);
					cursor = midNode.right;
				}
			} while (!stack.isEmpty() || null != cursor);
			// while (null != cursor || !stack.isEmpty()) {
			// if (null != cursor) {
			// stack.push(cursor);
			// cursor = cursor.left;
			// } else {// 表示栈不空
			// TreeNode midNode = stack.pop();
			// list.add(midNode.val);
			// cursor = midNode.right;
			// }
			// }

			return list;
		}
	}
}
