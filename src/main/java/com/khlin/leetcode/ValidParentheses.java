package com.khlin.leetcode;

import java.util.*;

/**
 * logo
 探索
 题库
 竞赛
 阅读
 社区
 商店
 0
 20.
 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 */
public class ValidParentheses {

	public static class Solution {

		public boolean isValid(String s) {
			if (null == s) {
				return false;
			}

			if ("".equals(s.trim())) {
				return true;
			}

			char[] chars = s.toCharArray();
			if (chars.length % 2 != 0) {
				return false;
			}

			Stack<Character> stack = new Stack<Character>();

			Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('}', '{');
			map.put(']', '[');
			map.put(')', '(');

			for (char c : chars) {
				// left bracket
				if (!map.containsKey(c)) {
					stack.push(c);
				} else // right bracket
				{
					if (stack.isEmpty()) {
						return false;
					}
					if (stack.pop() != map.get(c)) {
						return false;
					}
				}
			}

			return stack.isEmpty();

		}

	}

	public static void main(String[] args) {

		Solution sl = new Solution();

		System.out.println(sl.isValid("()"));
		System.out.println(sl.isValid("()[]{}"));
		System.out.println(sl.isValid("(]"));
		System.out.println(sl.isValid("([)]"));
		System.out.println(sl.isValid("{[]}"));
	}
}
