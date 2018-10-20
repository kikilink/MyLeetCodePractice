package com.khlin.leetcode;

import java.util.Arrays;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,4] 输出: [24,12,8,6] 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶： 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf {

	public static class Solution {
		public int[] productExceptSelf(int[] nums) {
			if (nums.length == 0) {
				return new int[0];
			}
			int[] result = new int[nums.length];
			int lastCursor = 1;
			// 先从左往右遍历，构造一个数组，每个索引位置i的值，是从0到(i-1)位置的乘积
			// 例如[1, 2, 3, 4]，则构造出[1, 1, 2, 6]
			result[0] = 1;
			for (int i = 1; i <= nums.length - 1; i++) {
				result[i] = nums[i - 1] * lastCursor;
				lastCursor = result[i];
			}

			// 从右往左遍历，每个索引的值等于当前位置的值（即所有左边的乘积）乘以右边所有位置的值
			int right = 1;
			for (int i = nums.length - 2; i >= 0; i--) {
				result[i] = result[i] * (right * nums[i + 1]);
				right = right * nums[i + 1];
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new Solution().productExceptSelf(new int[] { 2, 3, 4, 5, 6 })));
	}
}
