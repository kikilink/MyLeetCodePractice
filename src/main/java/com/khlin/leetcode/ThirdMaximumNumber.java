package com.khlin.leetcode;

import java.util.Arrays;

public class ThirdMaximumNumber {

	public static class Solution {
		public int thirdMax(int[] nums) {
			if (nums.length == 1) {
				return nums[0];
			}

			if (nums.length == 2) {
				return Math.max(nums[0], nums[1]);
			}

			//倒序数组
			int[] maxNums = new int[3];
			int size = 0;
			for (int num : nums) {
				switch (size) {
				case 0:
					maxNums[0] = num;
					size++;
					break;
				case 1:
					if (num > maxNums[0]) {
						System.arraycopy(maxNums, 0, maxNums, 1, 1);
						maxNums[0] = num;
                        size++;
					} else if (num < maxNums[0]) {
						maxNums[1] = num;
                        size++;
					}

					break;
				case 2:
					if (num > maxNums[0]) {
						System.arraycopy(maxNums, 0, maxNums, 1, 2);
						maxNums[0] = num;
                        size++;
					} else if (num < maxNums[0] && num > maxNums[1]) {
						System.arraycopy(maxNums, 1, maxNums, 2, 1);
						maxNums[1] = num;
                        size++;
					} else if (num < maxNums[1]) {
						maxNums[2] = num;
                        size++;
					}
					break;

				case 3:
					if (num > maxNums[0]) {
						System.arraycopy(maxNums, 0, maxNums, 1, 2);
						maxNums[0] = num;
					} else if (num < maxNums[0] && num > maxNums[1]) {
						System.arraycopy(maxNums, 1, maxNums, 2, 1);
						maxNums[1] = num;
					} else if (num < maxNums[1] && num > maxNums[2]) {
						maxNums[2] = num;
					}
					break;
				default:
					break;
				}
			}

			return size != 3 ? maxNums[0] : maxNums[2];
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().thirdMax(new int[] { 1, 2, 2 }));
	}
}
