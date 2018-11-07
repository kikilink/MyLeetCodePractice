package com.khlin.leetcode.linked.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 反转字符串中的元音字母
 * 
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello" 输出: "holle" 示例 2:
 * 
 * 输入: "leetcode" 输出: "leotcede" 说明: 元音字母不包含字母"y"。
 */
public class ReverseVowelsOfAString {

	public static class Solution {
		public String reverseVowels(String s) {
			if (null == s) {
				return null;
			}

			Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'a', 'O',
					'o', 'E', 'e', 'U', 'u', 'I', 'i'));
			char[] chars = s.toCharArray();
			int head = 0;
			int tail = chars.length - 1;
			while (head < tail) {
				while (head < tail && head <= chars.length - 1) {
					if (!vowels.contains(chars[head])) {
						head++;
					} else {
						break;
					}
				}

				while (tail > head && tail >= 0) {
					if (!vowels.contains(chars[tail])) {
						tail--;
					} else {
						break;
					}
				}

				if (head < tail) {
					char tmp = chars[head];
					chars[head] = chars[tail];
					chars[tail] = tmp;
					head++;
					tail--;
				}
			}

			return new String(chars);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseVowels(""));
	}
}
