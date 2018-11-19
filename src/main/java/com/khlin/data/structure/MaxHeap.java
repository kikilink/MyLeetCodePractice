package com.khlin.data.structure;

import java.util.ArrayList;
import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

	private ArrayList<E> data;

	public MaxHeap(int capacity) {
		data = new ArrayList<>(capacity);
	}

	public MaxHeap() {
		data = new ArrayList<>();
	}

	public MaxHeap(E[] copy) {
		this.data = new ArrayList<>(copy.length);
		for (int i = 0; i <= copy.length - 1; i++) {
			this.data.add(copy[i]);
		}

		for (int i = parent(data.size() - 1); i >= 0; i++) {
			shiftDown(i);
		}
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void add(E e) {
		data.add(e);
		shiftUp(data.size() - 1);
	}

	private void shiftUp(int k) {
		while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
			swap(k, parent(k));
			k = parent(k);
		}
	}

	public E extractMax() {
		E ret = findMax();
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		shiftDown(0);
		return ret;
	}

	private void shiftDown(int k) {

		// 不是叶子
		while (leftChild(k) <= data.size() - 1) {
			int j = leftChild(k);

			// 存在右节点，并且右节点的值比左节点大
			if (j + 1 < data.size()
					&& data.get(j + 1).compareTo(data.get(j)) > 0) {
				j++;
			}

			if (data.get(k).compareTo(data.get(j)) > 0) {
				break;
			}

			swap(k, j);
			k = j;
		}
	}

	public E findMax() {
		if (data.isEmpty()) {
			throw new IllegalArgumentException(
					"Cannot findMax when heap is empty.");
		}

		return data.get(0);
	}

	public E replace(E e) {
		E ret = findMax();
		data.set(0, e);
		shiftDown(0);
		return ret;
	}

	private void swap(int i, int j) {
		E tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}

	private int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index-0 doesnt have parent.");
		}
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return index * 2 + 1;
	}

	private int rightChild(int index) {
		return index * 2 + 2;
	}

	public static void main(String[] args) {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}

		System.out.println("Test MaxHeap completed.");
	}
}
