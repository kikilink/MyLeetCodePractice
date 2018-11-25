package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

		private class PostTreeNode {
			public TreeNode treeNode;

			// 右子树是否已经访问。默认false，表示未访问。反之表示已访问。
			public boolean rightVisited;

			public PostTreeNode(boolean rightVisited, TreeNode treeNode) {
				this.rightVisited = rightVisited;
				this.treeNode = treeNode;
			}
		}

		public List<Integer> postorderTraversalNR(TreeNode root) {
			if (null == root) {
				return Collections.emptyList();
			}

			List<Integer> list = new LinkedList<>();
			Stack<PostTreeNode> stack = new Stack<>();
			TreeNode cursor = root;

			do {
				// 先遍历一趟左子树
				while (null != cursor) {
					stack.push(new PostTreeNode(false, cursor));
					cursor = cursor.left;
				}

				while (!stack.isEmpty()) {
					PostTreeNode postTreeNode = stack.pop();
					// 右子树已经访问了，可以处理当前节点
					if (postTreeNode.rightVisited) {
						list.add(postTreeNode.treeNode.val);
					} else {// 否则继续访问右子树
						cursor = postTreeNode.treeNode.right;
						postTreeNode.rightVisited = true;
						stack.push(postTreeNode);
						break;
					}
				}
				// 加这个条件，是因为有可能是break出来的，这时还有根节点未遍历。
			} while (!stack.isEmpty());

			return list;
		}
	}
}
