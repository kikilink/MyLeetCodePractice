package com.khlin.leetcode;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
 * 朵花？能则返回True，不能则返回False。
 * 
 * 示例 1:
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 1 输出: True 示例 2:
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 2 输出: False 注意:
 * 
 * 数组内已种好的花不会违反种植规则。 输入的数组长度范围为 [1, 20000]。 n 是非负整数，且不会超过输入数组的大小。
 */
public class CanPlaceFlowers {

	public static class Solution {
		/**
		 * 主要是统计有多少连续的0. 考虑以下几种情况：
         * 1. 000在中间。前后都有1， 那么可以种下 (size - 1) / 2 的花；
         * 2. 000在开头或结尾。可以种下 size / 2 的花；
         * 3. 全部都是0，即花坛是全空的，都可以种，那么当花坛长度为奇数，可以种下(size + 1) / 2, 偶数则种下 size/2, 综合起来是
		 * (size + 1) / 2
		 */
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			int size = 0;
			int countOfCanPlace = 0;
			boolean allFreePlace = true;
			boolean isFirst = true;
			for (int i = 0; i <= flowerbed.length - 1; i++) {
				if (flowerbed[i] == 0) {
					size++;
				} else {
					allFreePlace = false;
					if (!isFirst) {
						countOfCanPlace += (size == 0 ? 0 : (size - 1) / 2);
					} else {
						countOfCanPlace += size / 2;
					}
					if (countOfCanPlace >= n) {
						return true;
					}

					isFirst = false;
					size = 0;
				}
			}

			// 说明中间都是零
			if (allFreePlace) {
				return (flowerbed.length + 1) / 2 >= n;
			}

			countOfCanPlace += size / 2;
			return countOfCanPlace >= n;
		}
	}

	public static void main(String[] args) {
		System.out.println(
				new Solution().canPlaceFlowers(new int[] { 0, 0, 0, 0 }, 2));

		System.out.println(
				new Solution().canPlaceFlowers(new int[] { 0, 0, 0, 0, 0 }, 3));

		System.out.println(
				new Solution().canPlaceFlowers(new int[] { 0, 1, 0, 0 }, 2));

		System.out.println(
				new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 1, 0 }, 3));

		System.out.println(
				new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0,0 , 1 }, 2));

	}
}
