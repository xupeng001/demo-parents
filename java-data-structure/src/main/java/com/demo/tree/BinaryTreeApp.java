package com.demo.tree;

import org.junit.Test;

public class BinaryTreeApp {

    @Test
    public void test() {

        BinaryTree tree = new BinaryTree();
        //        for (int i = 10; i >0; i--) {
        //            tree.insert(i);
        //        }
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(55);
        tree.insert(148);
        tree.insert(151);
        tree.displayTree();
        tree.delete(100);
        tree.displayTree();
    }
}
