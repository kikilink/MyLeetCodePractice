package com.khlin.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 */
public class MoveZeros {

	public static class Solution {

		public void moveZeroes(int[] nums) {
			int count = 0;
			for (int i = 0; i <= nums.length - 1; i++) {
			    //如果遇到尾部都是0的数组，可能造成死循环，必须限制count的值。
				while (nums[i] == 0 && i + 1 <= nums.length - 1
						&& i + count <= nums.length - 1) {
					System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
					count++;
				}
			}

			Arrays.fill(nums, nums.length - count, nums.length, 0);
		}
	}

	public static void main(String[] args) {
		new Solution().moveZeroes(new int[] { 0, 0, 0 });
	}
}
