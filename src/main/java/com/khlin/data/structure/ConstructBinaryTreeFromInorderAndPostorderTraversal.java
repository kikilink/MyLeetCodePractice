package com.khlin.data.structure;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意: 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7] 后序遍历 postorder = [9,15,7,20,3] 返回如下的二叉树：
 * 
 * 3 / \ 9 20 / \ 15 7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
					postorder.length - 1);
		}

		private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
				int[] postorder, int postStart, int postEnd) {
			if (inStart > inEnd) {
				return null;
			}

			if (inStart == inEnd) {
				return new TreeNode(inorder[inStart]);
			}

			// 先找出树的根节点
			TreeNode root = new TreeNode(postorder[postEnd]);

			// 遍历找出中序的根节点位置，其左为左子树，右为右子树
			int cursor = inStart;
			while (cursor <= inEnd) {
				// 找到根节点了
				if (inorder[cursor] == root.val) {
					break;
				}
				cursor++;
			}

			// 左树的节点数
			int leftTreeLength = cursor - inStart;

			//递归，注意取区间的下标要排除根节点
			root.left = buildTree(inorder, inStart, cursor - 1, postorder,
					postStart, postStart + leftTreeLength - 1);
			root.right = buildTree(inorder, cursor + 1, inEnd, postorder,
					postStart + leftTreeLength, postEnd - 1);

			return root;
		}
	}
}
