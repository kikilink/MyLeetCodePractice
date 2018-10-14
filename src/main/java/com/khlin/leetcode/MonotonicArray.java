package com.khlin.leetcode;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A
 * 是单调递减的。
 * 
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,2,2,3] 输出：true 示例 2：
 * 
 * 输入：[6,5,4,4] 输出：true 示例 3：
 * 
 * 输入：[1,3,2] 输出：false 示例 4：
 * 
 * 输入：[1,2,4,5] 输出：true 示例 5：
 * 
 * 输入：[1,1,1] 输出：true
 * 
 * 
 * 提示：
 * 
 * 1 <= A.length <= 50000 -100000 <= A[i] <= 100000
 */
public class MonotonicArray {
	public static class Solution {
		public boolean isMonotonic(int[] A) {

			if (A.length < 2) {
				return true;
			}

			// true表示递增，false表示递减
			boolean trend = true;

			// 防止开头就是一连串的相等的数
			boolean found = false;
			for (int i = 0; i <= A.length - 2; i++) {
				if (!found && A[i] > A[i + 1]) {
					trend = false;
					found = true;
				} else if (!found && A[i] < A[i + 1]) {
					trend = true;
					found = true;
				}

				if (found && trend && A[i] > A[i + 1]) {
					return false;
				} else if (found && !trend && A[i] < A[i + 1]) {
					return false;
				}
			}

			return true;
		}
	}

	public static void main(String[] args) {
		System.out
				.println(new Solution().isMonotonic(new int[] { 1, 2, 2, 3 }));
	}
}
