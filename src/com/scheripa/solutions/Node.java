package com.scheripa.solutions;

//public class BinarySearchTree {
public class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;

	}

	private void insert(int value) {
		// TODO Auto-generated method stub
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}

	private boolean contains(int value) {
		if (data == value) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}

		} else{
			if (right == null) {
				return false;
			} else {
				return	right.contains(value);
			}
		}
	}

	private void printOrder() {
		// TODO Auto-generated method stub
		if (left != null) {
			left.printOrder();
		}
		System.out.println(data);

		if (right != null) {
			right.printOrder();
		}

	}

	public static void main(String[] args) {

		Node n = new Node(11);
		n.insert(222);

		n.insert(2);
		n.insert(34);
		n.insert(56);
		n.printOrder();
		System.out.println(""+n.contains(222));
	}

}
