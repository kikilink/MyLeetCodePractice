package com.khlin.leetcode;

import java.util.*;

/**
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"] 输出: 9 解释: ((2 + 1) * 3) = 9 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"] 输出: 6 解释: (4 + (13 / 5)) = 6 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] 输出:
 * 22 解释: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) +
 * 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0 + 17) + 5 =
 * 17 + 5 = 22
 */
public class EvaluateReversePolishNotation {

	public static class Solution {

		public int evalRPN(String[] tokens) {
			Deque<Integer> numbers = new ArrayDeque<Integer>(tokens.length);
			for (String token : tokens) {

				switch (token) {
				case "+":
					numbers.addLast(
							numbers.removeLast() + numbers.removeLast());
					break;
				case "-":
					numbers.addLast(
							-(numbers.removeLast() - numbers.removeLast()));
					break;
				case "*":
					numbers.addLast(
							numbers.removeLast() * numbers.removeLast());
					break;
				case "/":
					int num1 = numbers.removeLast();
					int num2 = numbers.removeLast();
					numbers.addLast(num2 / num1);
					break;
				default:
					numbers.addLast(Integer.valueOf(token));
					break;

				}
			}

			return numbers.removeFirst();
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(new Solution()
				.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(new Solution().evalRPN(new String[] { "10", "6", "9",
				"3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}
}
