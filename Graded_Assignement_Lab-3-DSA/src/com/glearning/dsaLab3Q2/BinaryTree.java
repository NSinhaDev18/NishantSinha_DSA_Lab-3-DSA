package com.glearning.dsaLab3Q2;

import java.util.HashSet;
import java.util.Set;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	void insert(int data) {
		root = insertRec(root, data);
	}

	Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	public boolean findPairWithSum(int sum) {
		Set<Integer> set = new HashSet<>();
		return findPairWithSum(root, sum, set);
	}

	private boolean findPairWithSum(Node root, int sum, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		if (findPairWithSum(root.left, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Pair found " + (sum - root.data) + ", " + root.data + " for the sum: " + sum);
			return true;
		}
		set.add(root.data);
		return findPairWithSum(root.right, sum, set);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Insert nodes
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		int sum1 = 240; // hard coded input 1
		if (!tree.findPairWithSum(sum1)) {
			System.out.println("Sum not found for " + sum1);
		}
		int sum2 = 150; // hard coded input 2
		if (!tree.findPairWithSum(sum2)) {
			System.out.println("Sum not found for " + sum2);
		}
	}
}
