package com.demo.tree.star;


public class Node {

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	private Node rightChildren;
	private Node leftChildren;
	private Node right;
	
	private int value;
	
	/**
	 * 层
	 */
	private int order;
	
	public Node getRightChildren() {
		return rightChildren;
	}
	public void setRightChildren(Node rightChildren) {
		this.rightChildren = rightChildren;
	}
	public Node getLeftChildren() {
		return leftChildren;
	}
	public void setLeftChildren(Node leftChildren) {
		this.leftChildren = leftChildren;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(int value) {
		super();
		this.value = value;
	}
	
	
}
