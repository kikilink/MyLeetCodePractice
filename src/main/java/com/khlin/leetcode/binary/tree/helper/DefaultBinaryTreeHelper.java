package com.khlin.leetcode.binary.tree.helper;

import java.util.LinkedList;
import java.util.Queue;

public class DefaultBinaryTreeHelper {

	public static TreeNode buildTree(Integer[] vals) {

		TreeNode root = new TreeNode(vals[0]);
		return buildTree(root, vals, 0);

	}

	private static TreeNode buildTree(TreeNode root, Integer[] vals,
			int rootNum) {
		root.val = vals[rootNum];

		int leftNum = 2 * rootNum + 1;
		if (leftNum <= vals.length - 1 && null != vals[leftNum]) {
			TreeNode left = new TreeNode(vals[leftNum]);
			root.left = left;
			buildTree(left, vals, leftNum);
		}

		int rightNum = 2 * rootNum + 2;
		if (rightNum <= vals.length - 1 && null != vals[rightNum]) {
			TreeNode right = new TreeNode(vals[rightNum]);
			root.right = right;
			buildTree(right, vals, rightNum);
		}

		return root;
	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}
}
