package com.khlin.leetcode;

import java.util.ArrayDeque;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

 注意:

 num 的长度小于 10002 且 ≥ k。
 num 不会包含任何前导零。
 示例 1 :

 输入: num = "1432219", k = 3
 输出: "1219"
 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 示例 2 :

 输入: num = "10200", k = 1
 输出: "200"
 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 示例 3 :

 输入: num = "10", k = 2
 输出: "0"
 解释: 从原数字移除所有的数字，剩余为空就是0。

 */
public class RemoveKDigits {

	/**
	 * 首先思考一个问题，假设给定N个正整数，如何排列出最小的数值？
	 * 很明显，答案就是按数字从小到大排列，也就是一个升序的序列。
	 * 这个问题的原理也类似，就是尽可能保留升序的数字序列，在高位保持值较小的数。
	 * 例如 210452， 要求移除3位，那么很明显，就应该是保留045。
	 * 从左往右，1比2小，1开头的数字肯定比2小，所以2要剔除掉。
	 * 当已经移除够了，不再移除。
	 */
	public static class Solution {

		public String removeKdigits(String num, int k) {
			if (k == num.length()) {
				return "0";
			}

			ArrayDeque<String> deque = new ArrayDeque<>();
			int left = k;
			for (char c : num.toCharArray()) {
				if (deque.isEmpty()) {
					deque.addLast(String.valueOf(c));
				} else {
					String cursor = deque.getLast();
					while (left > 0 && cursor.compareTo(String.valueOf(c)) > 0) {
						deque.removeLast();
						left--;
						if (deque.isEmpty()) {
							break;
						}
						cursor = deque.getLast();
					}
					deque.addLast(String.valueOf(c));
				}
			}

			while (left > 0) {
				deque.removeLast();
				left--;
			}

			while (!deque.isEmpty() && "0".equals(deque.getFirst())) {
				deque.removeFirst();
			}

			String result = String.join("", deque);

			return "".equals(result) ? "0" : result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().removeKdigits("3045", 1));
	}
}
