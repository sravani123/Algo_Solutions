//package com.scheripa.solutions;
//
//import java.util.Stack;
//
//public class ConvertTernaryToBinaryTree {
//	static class TreeNode {
//		char c;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode(char c) {
//			this.c = c;
//			left = null;
//			right = null;
//		}
//
//	public TreeNode tenaryToTree(String s) {
//		if (s.length() == 0)
//			return null;
//
//		TreeNode root = new TreeNode(s.charAt(0));
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(root);
//
//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(i) == '?') {
//				TreeNode node = stack.peek();
//				node.left = new TreeNode(s.charAt(i + 1));
//				stack.push(node.left);
//			} else if (s.charAt(i) == ':') {
//				stack.pop();
//				TreeNode node = stack.pop();
//				node.right = new TreeNode(s.charAt(i + 1));
//				stack.push(node.right);
//			}
//		}
//System.out.println("rooot truee s ===>>"+root.toString());
//		return root;
//	}
//	public static void main(String[] args) {
//		ConvertTernaryToBinaryTree convertTernary = new ConvertTernaryToBinaryTree();
//		convertTernary.tenaryToTree("a?b:c");
//	}
//
//}
