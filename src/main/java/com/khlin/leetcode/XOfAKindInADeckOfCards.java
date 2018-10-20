package com.khlin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {

	public static class Solution {
		public boolean hasGroupsSizeX(int[] deck) {
			if (null == deck || deck.length == 0 || deck.length == 1) {
				return false;
			}

			for (int x = 2; x <= deck.length; x++) {
				if (deck.length % x != 0) {
					continue;
				}

				int group = deck.length / x;
				Map<Integer, Integer> groups = new HashMap<>(group);

				for (int i = 0; i <= deck.length - 1; i++) {
					Integer count = groups.get(deck[i]);
					if (count == null) {
						groups.put(Integer.valueOf(deck[i]),
								Integer.valueOf(1));
					} else {
						count += 1;
						// 到达分组的要求
						if (count == x) {
							groups.remove(Integer.valueOf(deck[i]));
						} else {
							groups.put(Integer.valueOf(deck[i]),
									Integer.valueOf(count));
						}
					}
				}

				if (groups.isEmpty()) {
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.hasGroupsSizeX(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 }));
		System.out.println(new Solution().hasGroupsSizeX(new int[] { 1, 1 }));

		System.out
				.println(new Solution().hasGroupsSizeX(new int[] { 1, 1, 1 }));
		System.out.println(new Solution()
				.hasGroupsSizeX(new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3 }));
	}
}
