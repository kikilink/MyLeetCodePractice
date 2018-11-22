package com.khlin.data.structure;

import com.khlin.leetcode.binary.tree.helper.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

	public static class Solution {
		public TreeNode constructFromPrePost(int[] pre, int[] post) {
			return constructFromPrePost(pre, 0, pre.length - 1, post, 0,
					post.length - 1);
		}

		private TreeNode constructFromPrePost(int[] pre, int preStart,
				int preEnd, int[] post, int postStart, int postEnd) {
			if (preStart > preEnd) {
				return null;
			}

			if (preStart == preEnd) {
				return new TreeNode(pre[preStart]);
			}

			// 先确定根节点
			TreeNode root = new TreeNode(pre[preStart]);

			if (preStart + 1 <= pre.length - 1) {
				// 二叉树有多种可能，只需要随意自定义一个左树的判断依据即可。这里取数组的第二个节点，当作左树的根。
				int leftTreeRootVal = pre[preStart + 1];
				int cursor = postStart;
				while (cursor <= postEnd - 1) {
					// 一定是可以找到的
					if (post[cursor] == leftTreeRootVal) {
						break;
					}
					cursor++;
				}

				// 找到后，在后序数组中，该下标为左子树，并且是在后序中，说明从开始位置到该下标，就是左子树。这是关键点。
				int leftTreeLength = cursor - postStart + 1;

				root.left = constructFromPrePost(pre, preStart + 1,
						preStart + leftTreeLength, post, postStart,
						postStart + leftTreeLength - 1);

				root.right = constructFromPrePost(pre,
						preStart + leftTreeLength + 1, preEnd, post,
						postStart + leftTreeLength, postEnd - 1);

			}

			return root;
		}
	}
}
