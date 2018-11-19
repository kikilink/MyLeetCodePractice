package com.khlin.leetcode;

/**
 * 字符串中的第一个唯一字符
 * 
 * 
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * s = "leetcode" 返回 0.
 * 
 * s = "loveleetcode", 返回 2.
 */
public class FirstUniqueCharacterInAString {

	public static class Solution {
		public int firstUniqChar(String s) {
			int[] hash = new int[26];

			for (int i = 0; i <= s.length() - 1; i++) {
				hash[s.charAt(i) - 'a']++;
			}

			for (int i = 0; i <= s.length() - 1; i++) {
				if (hash[s.charAt(i) - 'a'] == 1) {
					return i;
				}
			}

			return -1;
		}
	}
}
