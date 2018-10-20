package com.khlin.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 
 * 你可以返回任何满足上述条件的数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[4,2,5,7] 输出：[4,5,2,7] 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 
 * 
 * 提示：
 * 
 * 2 <= A.length <= 20000 A.length % 2 == 0 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

	/**
	 * 巧妙利用栈
	 */
	public static class Solution {
		public int[] sortArrayByParityII(int[] A) {
			Deque<Integer> unmatchedStack = new ArrayDeque<>(A.length);
			for (int i = 0; i <= A.length - 1; i++) {
				// 需要处理的元素
				if ((isOdd(i) && isEven(A[i])) || (isEven(i) && isOdd(A[i]))) {
					if (unmatchedStack.isEmpty()) {
						unmatchedStack.addLast(i);

					} else {
						int lastIndex = unmatchedStack.getLast();
						// 从栈里找到刚好相反的
						if ((isOdd(A[lastIndex]) && isEven(A[i])
								|| (isEven(A[lastIndex]) && isOdd(A[i])))) {
							swap(A, lastIndex, i);
							unmatchedStack.removeLast();
						} else {
							unmatchedStack.addLast(i);
						}

					}

				}
			}

			return A;
		}

		private boolean isOdd(int i) {
			return i % 2 == 1;
		}

		private boolean isEven(int i) {
			return i % 2 == 0;
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		public static void main(String[] args) {
			System.out.println(Arrays.toString(new Solution()
					.sortArrayByParityII(new int[] { 1, 3, 2, 4, 5, 6 })));
		}
	}

}
