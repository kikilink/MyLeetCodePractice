package com.khlin.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一手顺子
 * 
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * 
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 
 * 如果她可以完成分组就返回 true，否则返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3 输出：true 解释：爱丽丝的手牌可以被重新排列为
 * [1,2,3]，[2,3,4]，[6,7,8]。 示例 2：
 * 
 * 输入：hand = [1,2,3,4,5], W = 4 输出：false 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * 
 * 
 * 提示：
 * 
 * 1 <= hand.length <= 10000 0 <= hand[i] <= 10^9 1 <= W <= hand.length
 */
public class HandOfStraights {

	public static class Solution {
		public boolean isNStraightHand(int[] hand, int W) {
			if (hand.length % W != 0) {
				return false;
			}

			int groups = hand.length / W;

			TreeMap<Integer, Integer> handsMap = new TreeMap<>();
			for (int num : hand) {
				Integer count = handsMap.get(num);
				if (count == null) {
					handsMap.put(num, Integer.valueOf(1));
				} else {
					handsMap.put(num, count.intValue() + 1);
				}
			}

			for (int i = 1; i <= groups; i++) {
				int firstDeck = handsMap.firstKey();
				for (int j = firstDeck; j <= firstDeck + W - 1; j++) {
					Integer count = handsMap.get(j);
					// 无法找到连续
					if (count == null) {
						return false;
					}
					// 找到了，就要抽出来
					if (count.intValue() == 1) {
						handsMap.remove(j);
					} else {
						handsMap.put(j, count.intValue() - 1);
					}
				}
			}

			return true;

		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 5));
	}
}
