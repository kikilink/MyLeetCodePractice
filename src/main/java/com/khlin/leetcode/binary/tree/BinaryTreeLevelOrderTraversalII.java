package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

	private static class LevelTreeNode {

		public int level = 0;

		public TreeNode treeNode;

		public LevelTreeNode(int level, TreeNode treeNode) {
			this.level = level;
			this.treeNode = treeNode;
		}

	}

	public static class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (null == root) {
				return Collections.emptyList();
			}

			Queue<LevelTreeNode> queue = new LinkedList<>();
			queue.add(new LevelTreeNode(0, root));
			List<List<Integer>> list = new LinkedList<>();
			while (!queue.isEmpty()) {
				LevelTreeNode levelTreeNode = queue.poll();
				if (list.size() - 1 < levelTreeNode.level) {
					list.add(new LinkedList<>());
				}
				list.get(levelTreeNode.level).add(levelTreeNode.treeNode.val);

				if (null != levelTreeNode.treeNode.left) {
					queue.add(new LevelTreeNode(levelTreeNode.level + 1,
							levelTreeNode.treeNode.left));
				}

				if (null != levelTreeNode.treeNode.right) {
					queue.add(new LevelTreeNode(levelTreeNode.level + 1,
							levelTreeNode.treeNode.right));
				}
			}

			Collections.reverse(list);
			return list;
		}
	}
}
