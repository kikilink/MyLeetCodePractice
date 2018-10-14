package com.khlin.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 问题：
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。

 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {

	public static class Solution {

		/**
		 * 思路：
		 * 每一个元素，都可能是让前面的元素找到的升高温度。
		 * 维护一个递减栈，当当前元素比栈顶元素大，就pop，同时栈的元素应该是记录值和索引，这样两个元素的索引相减就可以得出最终的值。
		 * @param temperatures
		 * @return
		 */
		public int[] dailyTemperatures(int[] temperatures) {
			Stack<Tuple> stack = new Stack<Tuple>();
			int[] minDaysOfRaise = new int[temperatures.length];
			for (int index = 0; index <= temperatures.length - 1; index++) {
				Tuple currentTuple = new Tuple();
				currentTuple.index = index;
				currentTuple.value = temperatures[index];
				while (!stack.isEmpty()) {
					Tuple top = stack.peek();
					// not found
					if (top.value >= currentTuple.value) {
						break;
					} else {
						//found
						top = stack.pop();
						minDaysOfRaise[top.index] = currentTuple.index - top.index;
					}
				}

				stack.push(currentTuple);
			}

			return minDaysOfRaise;
		}

		private static class Tuple {
			public int value;

			public int index;
		}

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().dailyTemperatures(
				new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}
}
