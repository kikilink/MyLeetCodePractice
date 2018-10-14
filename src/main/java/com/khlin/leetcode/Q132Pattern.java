package com.khlin.leetcode;

import java.util.ArrayDeque;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak <
 * aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * 
 * 注意：n 的值小于15000。
 * 
 * 示例1:
 * 
 * 输入: [1, 2, 3, 4]
 * 
 * 输出: False
 * 
 * 解释: 序列中不存在132模式的子序列。 示例 2:
 * 
 * 输入: [3, 1, 4, 2]
 * 
 * 输出: True
 * 
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2]. 示例 3:
 * 
 * 输入: [-1, 3, 2, 0]
 * 
 * 输出: True
 * 
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class Q132Pattern {

	public static class Solution {

		/**
		 * 如果从左往右
		 *
		 * @param nums
		 * @return
		 */
		public boolean find132pattern(int[] nums) {
			if (nums.length < 3) {
				return false;
			}
			// 查找某个位置，左边最小的值。左边的值要尽可能的小。
			int[] minNumbers = new int[nums.length];
			minNumbers[0] = nums[0];
			// 头尾的不必计算，肯定不能作为132的中间
			for (int i = 1; i <= nums.length - 2; i++) {
				minNumbers[i] = Math.min(nums[i], minNumbers[i - 1]);
			}

			for (int i = 1; i <= nums.length - 1; i++) {
				if (minNumbers[i] < nums[i]) {
					for (int j = i + 1; j <= nums.length - 1; j++) {
						if (nums[i] > nums[j] && nums[j] > minNumbers[i]) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.find132pattern(new int[] { -2,1,-1}));
		System.out.println(
				new Solution().find132pattern(new int[] { 3, 1, 4, 2 }));
		System.out.println(
				new Solution().find132pattern(new int[] { -1, 3, 2, 0 }));

		System.out.println(
				new Solution().find132pattern(new int[] { 3, 5, 0, 3, 4 }));
	}
}
