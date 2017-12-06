package com.demo.tree.star;

public class BinaryStarTree {

	private Node root;

	public void insert(int value) {

		/**
		 * 根节点
		 */
		if (root == null) {
			root = new Node(value);
			return;
		}

		Node current = root;
		Node parent;
		while (true) {
			parent = current;
			if (value < current.getValue()) {
				current = current.getLeftChildren();
				if (current == null) {
					parent.setLeftChildren(new Node(value));
					return;
				}
			} else {
				current = current.getRightChildren();
				if (current == null) {
					parent.setRightChildren(new Node(value));
					return;
				}
			}

		}
	}
}
