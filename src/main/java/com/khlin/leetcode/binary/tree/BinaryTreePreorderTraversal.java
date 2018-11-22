package com.khlin.leetcode.binary.tree;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,2,3] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal {

	public static class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> list = new LinkedList<>();
			preorderTraversal(root, list);
			return list;
		}

		private void preorderTraversal(TreeNode root, List<Integer> list) {
			if (null == root) {
				return;
			}

			list.add(root.val);
			preorderTraversal(root.left, list);
			preorderTraversal(root.right, list);
		}
	}
}
