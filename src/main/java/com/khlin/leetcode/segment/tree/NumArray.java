package com.khlin.leetcode.segment.tree;

public class NumArray {

	private SegmentTree segmentTree;

	public NumArray(int[] nums) {
		segmentTree = new SegmentTree(nums);
	}

	public void update(int i, int val) {
		segmentTree.set(i, val);
	}

	public int sumRange(int i, int j) {
		return segmentTree.sumRange(i, j);
	}

	private class SegmentTree {

		private Integer[] data;

		private Integer[] tree;

		private Merger<Integer> merger = new Merger<Integer>() {
			@Override
			public Integer merge(Integer a, Integer b) {
				return a.intValue() + b.intValue();
			}
		};

		public SegmentTree(int[] nums) {
			if (null == nums || nums.length == 0) {
				throw new IllegalArgumentException(
						"Nums can't be null or empty");
			}
			data = new Integer[nums.length];
			for (int i = 0; i <= nums.length - 1; i++) {
				data[i] = Integer.valueOf(nums[i]);
			}

			tree = new Integer[4 * data.length];
			buildTree(0, 0, data.length - 1);
		}

		private void buildTree(int treeIndex, int left, int right) {
			// 找到叶子节点了
			if (left == right) {
				tree[treeIndex] = data[left];
				return;
			}

			int leftChildIndex = getLeft(treeIndex);
			int rightChildIndex = getRight(treeIndex);

			// 防止溢出
			int middle = left + (right - left) / 2;

			// 左右树递归
			buildTree(leftChildIndex, left, middle);
			buildTree(rightChildIndex, middle + 1, right);

			// 合并
			tree[treeIndex] = merger.merge(tree[leftChildIndex],
					tree[rightChildIndex]);

		}

		private int getLeft(int treeIndex) {
			return 2 * treeIndex + 1;
		}

		private int getRight(int treeIndex) {
			return 2 * treeIndex + 2;
		}

		public int sumRange(int i, int j) {
			if (i > j || i < 0 || j > data.length - 1) {
				throw new IllegalArgumentException("index error.");
			}

			return sumRange(0, 0, data.length - 1, i, j);
		}

		private int sumRange(int treeIndex, int left, int right, int queryLeft,
				int queryRight) {
			// 注意，queryLeft和queryRight是随时发生变化的。查询的目标是找到合适的区间，与上面递归到叶子节点不同。
			if (left == queryLeft && right == queryRight) {
				return tree[treeIndex];
			}

			// 否则还要细分
			int leftChildIndex = getLeft(treeIndex);
			int rightChildIndex = getRight(treeIndex);

			int middle = left + (right - left) / 2;
			// 只在左树找
			if (queryRight <= middle) {
				return sumRange(leftChildIndex, left, middle, queryLeft,
						queryRight);
				// 只在右树找
			} else if (queryLeft >= middle + 1) {
				return sumRange(rightChildIndex, middle + 1, right, queryLeft,
						queryRight);
			}

			return merger.merge(
					sumRange(leftChildIndex, left, middle, queryLeft, middle),
					sumRange(rightChildIndex, middle + 1, right, middle + 1,
							queryRight));

		}

		public void set(int index, int val) {
			if (index < 0 || index > data.length) {
				throw new IllegalArgumentException("index out of range.");
			}

			data[index] = val;
			set(0, 0, data.length - 1, index, val);
		}

		private void set(int treeIndex, int left, int right, int index,
				int val) {

			if (left == right) {
				tree[treeIndex] = val;
				return;
			}

			int middle = left + (right - left) / 2;
			int leftChildIndex = getLeft(treeIndex);
			int rightChildIndex = getRight(treeIndex);

			if (index >= middle + 1) {
				set(rightChildIndex, middle + 1, right, index, val);
			} else {
				set(leftChildIndex, left, middle, index, val);
			}

			tree[treeIndex] = merger.merge(tree[leftChildIndex],
					tree[rightChildIndex]);
		}
	}

	private interface Merger<E> {

		E merge(E a, E b);
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 4, 1, 3, 2, 5 };
		NumArray numArray = new NumArray(nums);

		System.out.println(numArray.sumRange(1, 5));
		numArray.update(5, 2);
		System.out.println(numArray.sumRange(1, 5));
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
