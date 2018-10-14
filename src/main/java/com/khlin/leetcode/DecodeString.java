package com.khlin.leetcode;

import java.util.*;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc". s = "3[a2[c]]", 返回 "accaccacc". s =
 * "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

	public static class Solution {

		public String decodeString(String s) {
			List<String> list = new ArrayList<String>();

			char[] originalChars = s.toCharArray();
			StringBuilder current = new StringBuilder();

			/**
			 * 先将字符按照类型分别入队列，方便后面计算，例如 2[abc]3[cd]ef 入队列后是 2, [, abc, ], 3, [,
			 * cd, ], ef 这一步也可以不做，后续回溯复杂一些而已。
			 */
			for (int index = 0; index <= originalChars.length - 1; index++) {
				char c = originalChars[index];
				if (isStart(c) || isEnd(c)) {
					list.add(String.valueOf(c));
				} else if (isDigit(c)) {
					current.append(c);
					// 标准格式，后面肯定有字符
					if (!isDigit(originalChars[index + 1])) {
						list.add(current.toString());
						current.delete(0, current.length());
					}
				} else {
					current.append(c);
					if (index == originalChars.length - 1
							|| isEnd(originalChars[index + 1])
							|| isDigit(originalChars[index + 1])) {
						list.add(current.toString());
						current.delete(0, current.length());
					}
				}
			}

			ArrayDeque<String> stack = new ArrayDeque<String>();
			for (String element : list) {
				/**
				 * 遇到结束符号，开始往回找公式计算。总是可以按照 n[xxxx] 的格式进行计算的。
				 * 即使是存在嵌套括号，如n[xxn[xx]]，在第一个]的时候，就已经计算并将结果进行替换。
				 */
				if (isEnd(element)) {
					List<String> marks = new ArrayList<String>();
					String cursor = stack.removeLast();
					do {
						marks.add(cursor);
					} while (!isStart((cursor = stack.removeLast())));

					Collections.reverse(marks);
					int times = Integer.parseInt(stack.removeLast());
					stack.addLast(new String(new char[times]).replace("\0",
							String.join("", marks)));
				} else {
					stack.addLast(element);
				}
			}

			return String.join("", stack);
		}

		private boolean isDigit(char c) {
			return c >= '0' && c <= '9';
		}

		private boolean isStart(char c) {
			return c == '[';
		}

		private boolean isEnd(char c) {
			return c == ']';
		}

		private boolean isEnd(String str) {
			return "]".equals(str);
		}

		private boolean isStart(String str) {
			return "[".equals(str);
		}

	}

	public static void main(String[] args) {
		System.out.println(new Solution().decodeString("3[a]2[bc]"));
	}
}
