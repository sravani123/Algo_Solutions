package com.scheripa.solutions;

import java.lang.reflect.Array;

public class LinkedList {
	Node head;

	private void deleteAtPosition(int position) {
		Node temp = head;
		if (head == null) {
			return;
		}
		if (position == 0) {
			head = temp.next;
		}
		for (int i = 0; i < position - 1 && temp!=null; i++) {
			temp = temp.next;
			Node next = temp.next.next;
			temp.next = next;
		}
	}

	private void delete(int key) {

		Node temp = head;
		Node prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			return;
		}
		prev.next = temp.next;

	}

	private void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;

	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;

		}

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.push(5);
		linkedList.printList();

		linkedList.delete(4);

		linkedList.printList();
		linkedList.deleteAtPosition(2);
		System.out.println('\n');
		linkedList.printList();


	}

}
