package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 层次遍历
 */
public class BinaryTreeLevelOrderTraversal {

	public static class Solution {
		private static class LevelTreeNode {

			public int level = 0;

			public TreeNode treeNode;

			public LevelTreeNode(int level, TreeNode treeNode) {
				this.level = level;
				this.treeNode = treeNode;
			}

		}

		public List<List<Integer>> levelOrder(TreeNode root) {
			if (null == root) {
				return Collections.emptyList();
			}
			List<List<Integer>> list = new ArrayList<>();
			Queue<LevelTreeNode> nodes = new LinkedList<>();

			nodes.add(new LevelTreeNode(0, root));

			while (!nodes.isEmpty()) {
				LevelTreeNode levelTreeNode = nodes.poll();
				int level = levelTreeNode.level;

				if (list.size() - 1 < level) {
					list.add(new ArrayList<>());
				}
				List<Integer> levelList = list.get(level);

				levelList.add(levelTreeNode.treeNode.val);

				if (null != levelTreeNode.treeNode.left) {
					nodes.add(new LevelTreeNode(level + 1,
							levelTreeNode.treeNode.left));
				}
				if (null != levelTreeNode.treeNode.right) {
					nodes.add(new LevelTreeNode(level + 1,
							levelTreeNode.treeNode.right));
				}
			}
			return list;
		}

	}
}
