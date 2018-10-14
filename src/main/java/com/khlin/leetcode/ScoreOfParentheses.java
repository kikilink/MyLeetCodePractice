package com.khlin.leetcode;

import java.util.ArrayDeque;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * 
 * () 得 1 分。 AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * 
 * 
 * 示例 1：
 * 
 * 输入： "()" 输出： 1 示例 2：
 * 
 * 输入： "(())" 输出： 2 示例 3：
 * 
 * 输入： "()()" 输出： 2 示例 4：
 * 
 * 输入： "(()(()))" 输出： 6
 * 
 * 
 * 提示：
 * 
 * S 是平衡括号字符串，且只含有 ( 和 ) 。 2 <= S.length <= 50
 */
public class ScoreOfParentheses {

	public static class Solution {

		public int scoreOfParentheses(String S) {
			//暂时保存分数
			ArrayDeque<String> deque = new ArrayDeque<>();
			for (char element : S.toCharArray()) {
				if (')' == element) {
					String cursor = deque.removeLast();

					long score = 0;
					//往前回溯到匹配的左括号。中间可能有已经子括号形成的数字，如(A)
					while (!"(".equals(cursor)) {
						score += Long.parseLong(cursor);
						cursor = deque.removeLast();
					}

					deque.addLast(String.valueOf(score == 0 ? 1 : score * 2));

				} else {
					deque.addLast(String.valueOf(element));
				}
			}

			int total = 0;
			for (String num : deque) {
				total += Integer.parseInt(num);
			}
			return total;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().scoreOfParentheses("()()"));
	}
}
