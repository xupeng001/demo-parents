package com.demo.tree;

import java.util.Stack;

/**
 * 类BinaryTree.java的实现描述：二叉树 从左往右递增
 * 
 * @author xupeng 2017年9月11日 下午6:05:31
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        /**
         * 跟为空
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
                /**
                 * 左子树
                 */
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(new Node(value));
                    return;
                }
            } else {
                /**
                 * 右子树
                 */
                current = current.getRight();
                if (current == null) {
                    parent.setRight(new Node(value));
                    return;
                }
            }

        }

    }

    public boolean delete(int value) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = true;
        while (current.getValue() != value) {
            parent = current;
            /**
             * 左边找
             */
            if (value < current.getValue()) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            /**
             * 么有找的数据
             */
            if (current == null) {
                return false;
            }
        }

        /**
         * 删除叶子节点
         */
        if (current.getLeft() == null && current.getRight() == null) {
            /**
             * 删除的是根节点没有子节点
             */
            if (current == root) {
                root = null;

            } else if (isLeftChild) {
                /**
                 * 删除左子节点
                 */
                parent.setLeft(null);

            } else {
                parent.setRight(null);
            }

        } else if (current.getRight() == null) {
            /**
             * 左子节点
             */
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            /**
             * 右子节点
             */
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }

        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }

        return true;
    }

    private Node getSuccessor(Node n) {
        Node successorParent = n;
        Node successor = n;
        Node current = n.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != n.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(n.getRight());
        }
        return successor;

    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.getValue() == key) {
                return current;
            }
            if (key < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current;

    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int size = 32;
        boolean isRowEmpty = false;
        System.out.println(".............................................................");
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;
            for (int i = 0; i < size; i++) {
                System.out.print(" ");
            }
            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < size * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
          
            System.out.println();
            size /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("..............................................................");

    }
}
